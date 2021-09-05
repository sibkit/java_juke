package juke.orm.net.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NetClient
{
    public void start()
    {
        try(Socket s = new Socket("localhost",20854);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());)
        {
            while(!s.isOutputShutdown())
            {


                dos.writeLong(System.nanoTime());

                dos.flush();
                Thread.sleep(2500);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void stop()
    {

    }
}
