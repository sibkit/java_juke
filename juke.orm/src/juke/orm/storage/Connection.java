package juke.orm.storage;

import juke.events.EventEmitter;
import juke.exceptions.JukeException;
import juke.orm.mapping.SequenceMap;
import juke.orm.querying.queries.Query;
import juke.orm.storage.operation.EntityOperation;
import juke.orm.storage.sequence.Sequence;
import juke.orm.storage.transaction.Transaction;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 07.01.12
 * Time: 10:16
 * To change this juke.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */
public interface Connection
{
    EventEmitter getAfterOperationExecuteEmitter();
    EventEmitter getBeforeOperationExecuteEmitter();
    void close() throws JukeException;
    boolean isClosed() throws JukeException;
	Transaction getCurrentTransaction();
    Transaction beginTransaction() throws JukeException;

	Sequence getSequence(SequenceMap map) throws JukeException;
    void executeOperation(EntityOperation operation) throws JukeException;
    StorageIterator iterate(Query query) throws JukeException;
}
