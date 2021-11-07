package juke.orm.net.messages.client;

import juke.orm.querying.queries.Query;

public class QueryNetMessage
{
    public static final String key = "Query";

    private Query query;



    public Query getQuery()
    {
        return query;
    }

    public void setQuery(Query query)
    {
        this.query = query;
    }
}
