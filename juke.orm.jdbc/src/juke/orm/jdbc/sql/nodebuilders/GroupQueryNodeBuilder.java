package juke.orm.jdbc.sql.nodebuilders;

import juke.orm.jdbc.sql.NameTarget;
import juke.orm.jdbc.sql.node.QueryNode;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.queries.GroupQuery;

import java.util.List;

public class GroupQueryNodeBuilder extends NodeBuilder<GroupQuery>
{
    @Override
    public QueryNode build(GroupQuery element, List<NameTarget> nameSpace)
    {
        return null;
    }

    @Override
    public QueryElementType getQueryElementType()
    {
        return null;
    }
}
