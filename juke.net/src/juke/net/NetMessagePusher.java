package juke.net;

import juke.net.messages.NetMessage;

import java.util.EventObject;

public interface NetMessagePusher
{
    void pushMessage(NetMessage msg);
}
