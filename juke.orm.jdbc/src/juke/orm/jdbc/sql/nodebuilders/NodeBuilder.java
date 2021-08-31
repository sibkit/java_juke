package juke.orm.jdbc.sql.nodebuilders;

import juke.orm.jdbc.sql.QueryBuilder;
import juke.orm.jdbc.sql.node.QueryNode;
import juke.orm.querying.QueryElement;
import juke.orm.querying.QueryElementType;
import juke.orm.jdbc.sql.NameTarget;

import java.util.List;

public abstract class NodeBuilder<T extends QueryElement>
{
    private QueryBuilder queryBuilder;
    public void initialize(QueryBuilder queryBuilder)
    {
        this.queryBuilder = queryBuilder;
    }

    public abstract QueryNode build(T element, List<NameTarget> nameSpace);
    public abstract QueryElementType getQueryElementType();

    public QueryBuilder getQueryBuilder()
    {
        return queryBuilder;
    }
}
