import juke.net.server.JukeServer;

public class ServerTest
{
    public static void main(String[] args)
    {
        JukeServer server = new JukeServer(new TestServerSocketInitializer());
        server.start(5648);
        System.out.println("Server started");
    }
}
