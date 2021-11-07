package juke.net.messages;

import juke.net.actions.NetActionProperty;

public class SubscribeNetMessage
{
    private String actionType;
    private NetActionProperty[] subscribeConditions;

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
