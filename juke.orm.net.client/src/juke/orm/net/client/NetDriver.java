package juke.orm.net.client;

import juke.exceptions.JukeException;
import juke.orm.MappingData;
import juke.orm.storage.Connection;
import juke.orm.storage.StorageDriver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NetDriver implements StorageDriver
{
    private MappingData mappingData;
    private String host = "localhost";
    private int port = 20854;

    @Override
    public void initialize(MappingData mappingData)
    {
        this.mappingData = mappingData;
    }

    @Override
    public Connection createConnection() throws JukeException
    {
        NetConnection result = new NetConnection();
        return result;
    }

    public void start()
    {
        try(Socket s = new Socket(host,port);
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

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public MappingData getMappingData()
    {
        return mappingData;
    }
}
