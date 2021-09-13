package juke.net;

import juke.events.EventEmitter;
import juke.net.messages.NetMessage;

public interface NetMessageHandler
{
    void initialize(NetMessagePusher pusher);

    String[] getProcessedMessageTypes();
    void processMessage(NetMessage messages);
}
