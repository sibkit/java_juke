package juke.net.server;

import juke.net.actions.NetActionProperty;

import java.util.ArrayList;
import java.util.List;

public class NetAction
{
    private String actionType;
    private List<NetActionProperty> actionProperties = new ArrayList<>();

    public String getActionType()
    {
        return actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public List<NetActionProperty> getActionProperties()
    {
        return actionProperties;
    }
}
