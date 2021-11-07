import juke.common.StreamUtils;
import juke.net.mapping.BaseMessageMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestMessageMapper extends BaseMessageMapper<TestMessage>
{
    @Override
    public String getTalkCode()
    {
        return TestMessage.class.getName();
    }

    @Override
    public void bindToStream(TestMessage message, OutputStream out) throws IOException
    {
        StreamUtils.writeString(message.getName(), out);
    }

    @Override
    public void bindToMessage(InputStream in, TestMessage message) throws IOException
    {
        message.setName(StreamUtils.readString(in));
    }

    @Override
    public TestMessage createMessage()
    {
        return new TestMessage();
    }
}
