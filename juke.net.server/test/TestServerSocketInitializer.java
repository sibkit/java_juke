import juke.net.HandlingBox;
import juke.net.SocketHandler;
import juke.net.mapping.AskTalkCodesMessageMapper;
import juke.net.server.AskTalkCodesMessageHandler;
import juke.net.SocketInitializer;

public class TestServerSocketInitializer implements SocketInitializer
{
    @Override
    public void initializeSocketHandler(SocketHandler sh)
    {
        sh.addHandlingBox(new HandlingBox<>(new AskTalkCodesMessageHandler(),new AskTalkCodesMessageMapper()));
        sh.addHandlingBox(new HandlingBox<>(new TestMessageHandler(), new TestMessageMapper()));
    }
}
