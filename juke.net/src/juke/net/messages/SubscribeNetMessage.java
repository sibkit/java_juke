package juke.net.messages;

import juke.net.actions.NetActionProperty;

public class SubscribeNetMessage extends NetMessage
{
    public static final String key = "Subscribe";

    private String actionType;
    private NetActionProperty[] subscribeConditions;

    public SubscribeNetMessage(int number)
    {
        super(number, key);
    }

    public NetActionProperty[] getSubscribeConditions()
    {
        return subscribeConditions;
    }

    public void setSubscribeConditions(NetActionProperty[] subscribeConditions)
    {
        this.subscribeConditions = subscribeConditions;
    }

    public String getActionType()
    {
        return actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
}
