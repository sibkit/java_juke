package juke.net.server;

import juke.events.EventHandler;
import juke.net.SocketHandler;
import juke.net.SocketInitializer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class JukeServer
{
    private static Map<Thread, SocketHandler> clientHandlers;
    private final static Object syncKey = new Object();
    private static Boolean stopServerRequired = false;
    private SocketInitializer initializer;

    public JukeServer(SocketInitializer initializer)
    {
        this.initializer = initializer;
    }

    public void stop()
    {
        synchronized (syncKey)
        {
            stopServerRequired = true;
        }
    }

    public SocketHandler getSocketHandler()
    {
        synchronized (syncKey)
        {
            return clientHandlers.get(Thread.currentThread());
        }
    }

    public void start(int port)
    {
        try
        {
            clientHandlers = new HashMap<>();
            ServerSocket ss = new ServerSocket(port);
            while (!stopServerRequired)
            {
                Socket sClient = ss.accept();
                SocketHandler sh = new SocketHandler(sClient);
                initializer.initializeSocketHandler(sh);
                Thread t = new Thread(sh);
                clientHandlers.put(t, sh);
                sh.getWorkEndEmitter().addHandler(new EventHandler<EventObject>()
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
