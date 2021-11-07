package juke.net;

public abstract class MessageHandler<T>
{
    private SocketHandler socketHandler;

    public void initialize(SocketHandler socketHandler)
    {
        this.socketHandler = socketHandler;
    }
    public SocketHandler getSocketHandler()
    {
        return socketHandler;
    }

    public abstract void handleMessage(T message);
}
