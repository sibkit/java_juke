package juke.net.server;

import juke.events.BaseEventEmitter;
import juke.events.EventEmitter;
import juke.net.NetMessagePusher;
import juke.net.messages.NetMessage;

import java.net.Socket;
import java.util.EventObject;

public class ClientHandler implements NetMessagePusher, Runnable
{
    private final Socket clientSocket;
    private final BaseEventEmitter<EventObject> workEndEmitter = new BaseEventEmitter<>();
    private boolean stopRequired = false;

    public ClientHandler(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    public void stop()
    {
        stopRequired = true;
    }

    public void run()
    {
        while (!stopRequired)
        {
            clientSocket.getChannel();
        }
        workEndEmitter.emit(new EventObject(this));
    }

    public EventEmitter<EventObject> getWorkEndEmitter()
    {
        return workEndEmitter;
    }

    @Override
    public void pushMessage(NetMessage msgs)
    {
        // send to client message code ... clientSocket.
    }
}
