package juke.net;

import juke.net.mapping.MessageMapper;

public class HandlingBox<T>
{
    private MessageHandler<T> handler;
    private MessageMapper<T> mapper;


    public HandlingBox(){}

    public HandlingBox(MessageHandler<T> handler, MessageMapper<T> mapper)
    {
        this.handler = handler;
        this.mapper = mapper;
    }

    public MessageHandler<T> getHandler()
    {
        return handler;
    }

    public void setHandler(MessageHandler<T> handler)
    {
        this.handler = handler;
    }

    public MessageMapper<T> getMapper()
    {
        return mapper;
    }

    public void setMapper(MessageMapper<T> mapper)
    {
        this.mapper = mapper;
    }


}
