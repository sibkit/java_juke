import juke.net.SocketHandler;

import java.io.IOException;
import java.net.Socket;

public class NetClientTest
{
    static String HOST = "192.168.1.1";
    static int PORT = 5648;

    public static void main(String[] args) throws IOException
    {


        SocketHandler sh = new SocketHandler(new Socket(HOST, PORT));
        sh.run();
    }
}
