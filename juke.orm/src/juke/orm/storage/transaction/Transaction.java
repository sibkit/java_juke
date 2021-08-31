package juke.orm.storage.transaction;


import juke.events.EventEmitter;
import juke.exceptions.JukeException;
import juke.orm.storage.operation.EntityOperation;

import java.util.EventObject;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 07.01.12
 * Time: 2:17
 * To change this utec.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */
public interface Transaction
{
    EventEmitter<EventObject> getStateChangedEmitter();
    EntityOperation[] getOperations();
    void begin() throws JukeException;
    void commit() throws JukeException;
    void rollback() throws JukeException;
    TransactionState getState();
}
