package juke.net.server;


import juke.net.MessageHandler;
import juke.net.messages.AskTalkCodesMessage;
import juke.net.messages.TalkCodesMessage;

import java.util.Map;

public class AskTalkCodesMessageHandler extends MessageHandler<AskTalkCodesMessage>
{
    @Override
    public void handleMessage(AskTalkCodesMessage message)
    {
        TalkCodesMessage result = new TalkCodesMessage();
        for(Map.Entry<Short, String> e : getSocketHandler().getTalkCodesManager().getTalkCodesMap().entrySet())
        result.getMessageCodesMap().put(e.getKey(),e.getValue());
        getSocketHandler().pushMessage(result);
    }
}
