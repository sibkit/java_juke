package juke.net.server;

import juke.events.EventHandler;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

public class JukeServer
{
    private final static int defaultSocket = 20854;
    private static Map<Thread, ClientHandler> clientHandlers;
    private final static Object syncKey = new Object();

    private static Boolean stopServerRequired = false;

    public static void stopServer()
    {
        synchronized (syncKey)
        {
            stopServerRequired = true;
        }
    }

    public static ClientHandler getClientHandler()
    {
        synchronized (syncKey)
        {
            return clientHandlers.get(Thread.currentThread());
        }
    }

    public static void main(String[] args)
    {
        try
        {
            int socket = defaultSocket;
            for(int i=0; i<args.length;i++)
            {
                if("-socket".equals(args[i]))
                {
                    if(args.length>i+1)
                        socket = Integer.parseInt(args[i+1]);
                    else
                        System.out.println("`-socket` parameter not defined");
                }
            }

            clientHandlers = new HashMap<>();
            ServerSocket ss = new ServerSocket(socket);
            while (!stopServerRequired)
            {
                Socket sClient = ss.accept();
                ClientHandler ch = new ClientHandler(sClient);
                Thread t = new Thread(ch);
                clientHandlers.put(t, ch);
                ch.getWorkEndEmitter().addHandler(new EventHandler<EventObject>()
                {
                    @Override
                    public void handle(EventObject event)
                    {
                        synchronized (syncKey)
                        {
                            clientHandlers.remove(Thread.currentThread());
                            System.out.print("Client disconnected");
                        }
                    }
                });
                t.start();
                System.out.print("Client connected");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
