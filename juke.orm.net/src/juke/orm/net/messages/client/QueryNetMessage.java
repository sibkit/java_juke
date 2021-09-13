package juke.orm.net.messages.client;

import juke.net.messages.NetMessage;
import juke.orm.querying.queries.Query;

public class QueryNetMessage extends NetMessage
{
    public static final String key = "Query";

    private Query query;

    public QueryNetMessage(int number)
    {
        super(number, key);
    }

    public Query getQuery()
    {
        return query;
    }

    public void setQuery(Query query)
    {
        this.query = query;
    }
}
