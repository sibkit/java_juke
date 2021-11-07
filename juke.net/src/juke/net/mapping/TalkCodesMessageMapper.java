package juke.net.mapping;

import juke.common.StreamUtils;
import juke.net.messages.TalkCodesMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class TalkCodesMessageMapper extends BaseMessageMapper<TalkCodesMessage>
{
    @Override
    public String getTalkCode()
    {
        return TalkCodesMessage.class.getName();
    }

    @Override
    public void bindToStream(TalkCodesMessage message, OutputStream out) throws IOException
    {
        StreamUtils.writeShort((short)message.getMessageCodesMap().size(), out);

        for(Map.Entry<Short,String> e : message.getMessageCodesMap().entrySet())
        {
            StreamUtils.writeShort(e.getKey(), out);
            StreamUtils.writeString(e.getValue(),out);
        }
    }

    @Override
    public void bindToMessage(InputStream in, TalkCodesMessage message) throws IOException
    {
        int size = StreamUtils.readShort(in);
        for(int i=0; i<size;i++)
        {
            short key = StreamUtils.readShort(in);
            String value = StreamUtils.readString(in);
            message.getMessageCodesMap().put(key,value);
        }
    }

    @Override
    public TalkCodesMessage createMessage()
    {
        return new TalkCodesMessage();
    }



}
