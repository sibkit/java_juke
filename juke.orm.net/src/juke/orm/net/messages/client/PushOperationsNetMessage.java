package juke.orm.net.messages.client;

import juke.net.messages.NetMessage;
import juke.orm.storage.operation.EntityOperation;

import java.util.List;

public class PushOperationsNetMessage extends NetMessage
{
    public static final String key = "EntityOperations";

    private List<EntityOperation> operations;

    public PushOperationsNetMessage(int number)
    {
        super(number, key);
    }

    public List<EntityOperation> getOperations()
    {
        return operations;
    }
}
