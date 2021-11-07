package juke.net;

import java.util.EventObject;

public class MessageEventObject<T> extends EventObject
{
    private final T message;
    public MessageEventObject(Object source, T message)
    {
        super(source);
        this.message = message;
    }

    public T getMessage()
    {
        return message;
    }
}
