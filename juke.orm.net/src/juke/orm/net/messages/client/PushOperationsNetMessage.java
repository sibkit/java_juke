package juke.orm.net.messages.client;

import juke.orm.storage.operation.EntityOperation;

import java.util.List;

public class PushOperationsNetMessage
{
    public static final String key = "EntityOperations";

    private List<EntityOperation> operations;



    public List<EntityOperation> getOperations()
    {
        return operations;
    }
}
