package juke.orm.net.client;

import juke.events.EventEmitter;
import juke.exceptions.JukeException;
import juke.orm.mapping.SequenceMap;
import juke.orm.querying.queries.Query;
import juke.orm.storage.Connection;
import juke.orm.storage.StorageIterator;
import juke.orm.storage.operation.EntityOperation;
import juke.orm.storage.sequence.Sequence;
import juke.orm.storage.transaction.Transaction;

public class NetConnection implements Connection
{
    @Override
    public EventEmitter getAfterOperationExecuteEmitter()
    {
        return null;
    }

    @Override
    public EventEmitter getBeforeOperationExecuteEmitter()
    {
        return null;
    }

    @Override
    public void close() throws JukeException
    {

    }

    @Override
    public boolean isClosed() throws JukeException
    {
        return false;
    }

    @Override
    public Transaction getCurrentTransaction()
    {
        return null;
    }

    @Override
    public Transaction beginTransaction() throws JukeException
    {
        return null;
    }

    @Override
    public Sequence getSequence(SequenceMap map) throws JukeException
    {
        return null;
    }

    @Override
    public void executeOperation(EntityOperation operation) throws JukeException
    {

    }

    @Override
    public StorageIterator iterate(Query query) throws JukeException
    {
        return null;
    }
}
