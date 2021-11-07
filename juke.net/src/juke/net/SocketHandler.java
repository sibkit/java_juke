package juke.net;

import juke.common.StreamUtils;
import juke.events.BaseEventEmitter;
import juke.events.EventEmitter;
import juke.net.mapping.MessageMapper;

import java.io.InputStream;

import java.net.Socket;
import java.util.*;

public class SocketHandler implements Runnable
{
    private final Object syncKey = new Object();

    private final List<? super Object> messagesToSend = new ArrayList<>();
    private final Socket clientSocket;
    private final TalkCodesManager talkCodesManager = new TalkCodesManager();

    private final BaseEventEmitter<EventObject> workEndEmitter = new BaseEventEmitter<>();
    private final BaseEventEmitter<MessageEventObject<?>> messageReceivedEmitter = new BaseEventEmitter<>();
    private boolean stopRequired = false;

    private int outSequence =0;
    private int inSequence=0;

    private final Map<Class<?>, HandlingBox<? super Object>> handlingBoxByClassMap = new HashMap<>();
    private final Map<String, HandlingBox<? super Object>> handlingBoxByTalkCodeMap = new HashMap<>();

    public SocketHandler(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }



    public void run()
    {
        try
        {
            while (!stopRequired && !clientSocket.isClosed())
            {
                Object[] outMessages = null;
                synchronized (syncKey)
                {
                    if (!messagesToSend.isEmpty())
                    {
                        outMessages = new Object[messagesToSend.size()];
                        messagesToSend.toArray(outMessages);
                        messagesToSend.clear();
                    }
                }

                assert outMessages != null;
                for (Object msg : outMessages)
                {
                    HandlingBox<? super Object> hb = handlingBoxByClassMap.get(msg.getClass());
                    MessageMapper<? super Object> mm = hb.getMapper();

                    StreamUtils.writeShort(talkCodesManager.getTalkCodeIndex(mm.getTalkCode()), clientSocket.getOutputStream());
                    StreamUtils.writeInt(outSequence++, clientSocket.getOutputStream());

                    mm.bindToStream(msg, clientSocket.getOutputStream());
                    clientSocket.getOutputStream().flush();
                }

                InputStream in = clientSocket.getInputStream();
                int a = in.available();
                if (a != 0)
                {
                    Short talkCodeIndex = (short) ((in.read() & 0xff) | (in.read() & 0xff) << 8);
                    String code = talkCodesManager.getTalkCodesMap().get(talkCodeIndex);

                    HandlingBox<? super Object> hb = handlingBoxByTalkCodeMap.get(code);
                    MessageHandler<? super Object> mh = hb.getHandler();
                    MessageMapper<? super Object> mm = hb.getMapper();

                    int number = ((in.read() & 0xFF) << 24) | ((in.read() & 0xFF) << 16) | ((in.read() & 0xFF) << 8) | ((in.read() & 0xFF));
                    if (inSequence == number)
                    {
                        inSequence++;
                    }
                    else
                    {
                        System.err.println("Income number sequence is broken");
                    }

                    Object msg = mm.createMessage();

                    mm.bindToMessage(in, msg);
                    mh.handleMessage(msg);

                    messageReceivedEmitter.emit(new MessageEventObject(this, msg));
                }
                else
                {
                    Thread.sleep(50);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        workEndEmitter.emit(new EventObject(this));
    }

    public void stop()
    {
        stopRequired = true;
    }

    public EventEmitter<EventObject> getWorkEndEmitter()
    {
        return workEndEmitter;
    }

    public void addHandlingBox(HandlingBox hb)
    {
        handlingBoxByClassMap.put(hb.getMapper().getMessageClass(),hb);
        talkCodesManager.registerTalkCode(hb.getMapper().getTalkCode());
        handlingBoxByTalkCodeMap.put(hb.getMapper().getTalkCode(),hb);
    }

    public Collection<HandlingBox<? super Object>> getHandlingBoxes()
    {
        return handlingBoxByClassMap.values();
    }

    public void removeHandlingBox(HandlingBox<?> hb)
    {
        synchronized (syncKey)
        {
            handlingBoxByClassMap.remove(hb.getMapper().getMessageClass());
            talkCodesManager.removeTalkCode(hb.getMapper().getTalkCode());
            handlingBoxByTalkCodeMap.remove(hb.getMapper().getTalkCode());
        }
    }

    public <T> void pushMessage(T msg)
    {
        synchronized (syncKey)
        {
            messagesToSend.add(msg);
        }
    }

    public TalkCodesManager getTalkCodesManager()
    {
        return talkCodesManager;
    }

}
