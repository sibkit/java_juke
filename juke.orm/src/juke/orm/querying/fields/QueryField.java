package juke.orm.querying.fields;

import juke.orm.querying.queries.Query;
import juke.orm.querying.QueryElementType;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 11.01.12
 * Time: 10:30
 * To change this juke.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */
public class QueryField extends Field
{
    private Query query;

    public Query getQuery()
    {
        return query;
    }

    public void setQuery(Query query)
    {
        this.query = query;
        query.setParent(this);
    }

    @Override
    public QueryElementType getElementType()
    {
        return QueryElementType.SUBQUERY_FIELD;
    }
}
