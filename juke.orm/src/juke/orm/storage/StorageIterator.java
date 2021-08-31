package juke.orm.storage;

import juke.common.Iterator;
import juke.orm.querying.queries.Query;


/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 19.01.12
 * Time: 15:39
 * To change this utec.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */
public interface StorageIterator extends Iterator<Object[]>
{
    Query getQuery();
}
