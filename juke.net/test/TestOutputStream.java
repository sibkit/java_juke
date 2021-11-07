import juke.net.mapping.TalkCodesMessageMapper;
import juke.net.messages.TalkCodesMessage;

import java.io.*;

public class TestOutputStream
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        TalkCodesMessageMapper mapper = new TalkCodesMessageMapper();

        TalkCodesMessage msg = mapper.createMessage();
        msg.getMessageCodesMap().put((short)0, TalkCodesMessage.class.getName());
        msg.getMessageCodesMap().put((short)1,"one");
        msg.getMessageCodesMap().put((short)2,"two");
        msg.getMessageCodesMap().put((short)3,"three");

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        mapper.bindToStream(msg,out);

        out.flush();
        byte[] bytes = out.toByteArray();

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        TalkCodesMessage msg2 = mapper.createMessage();
        mapper.bindToMessage(in, msg2);
        System.out.println("Ok");
    }
}
