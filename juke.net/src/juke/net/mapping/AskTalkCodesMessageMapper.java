package juke.net.mapping;

import juke.net.MessageHandler;
import juke.net.messages.AskTalkCodesMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AskTalkCodesMessageMapper extends BaseMessageMapper<AskTalkCodesMessage>
{
    @Override
    public String getTalkCode()
    {
        return "ASK_TALK_CODE";
    }

    @Override
    public AskTalkCodesMessage createMessage()
    {
        return new AskTalkCodesMessage();
    }

    public void bindToStream(AskTalkCodesMessage message, OutputStream out) throws IOException
    {

    }

    public void bindToMessage(InputStream in, AskTalkCodesMessage message) throws IOException
    {

    }

}
