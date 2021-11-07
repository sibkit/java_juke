
import juke.net.MessageHandler;

public class TestMessageHandler extends MessageHandler<TestMessage>
{
    @Override
    public void handleMessage(TestMessage message)
    {
        TestMessage msg = new TestMessage();
        msg.setName("Server speak!");
        getSocketHandler().pushMessage(msg);
    }
}
