package juke.orm.net.client;

import juke.events.EventEmitter;
import juke.exceptions.JukeException;
import juke.orm.storage.operation.EntityOperation;
import juke.orm.storage.transaction.Transaction;
import juke.orm.storage.transaction.TransactionState;

import java.util.EventObject;

public class NetTransaction implements Transaction
{
    @Override
    public EventEmitter<EventObject> getStateChangedEmitter()
    {
        return null;
    }

    @Override
    public EntityOperation[] getOperations()
    {
        return new EntityOperation[0];
    }

    @Override
    public void begin() throws JukeException
    {

    }

    @Override
    public void commit() throws JukeException
    {

    }

    @Override
    public void rollback() throws JukeException
    {

    }

    @Override
    public TransactionState getState()
    {
        return null;
    }
}
