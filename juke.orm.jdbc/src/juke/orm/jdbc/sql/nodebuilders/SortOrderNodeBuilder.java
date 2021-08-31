package juke.orm.jdbc.sql.nodebuilders;

import juke.orm.jdbc.sql.node.NodePartType;
import juke.orm.jdbc.sql.node.NodeType;
import juke.orm.jdbc.sql.node.ValuePartType;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.sorting.SortOrder;
import juke.orm.jdbc.sql.NameTarget;
import juke.orm.jdbc.sql.node.QueryNode;

import java.util.List;

public class SortOrderNodeBuilder extends NodeBuilder<SortOrder>
{
    @Override
    public QueryNode build(SortOrder element, List<NameTarget> nameSpace)
    {
        QueryNode snSortOrder = new QueryNode(NodeType.SORT_ORDER);
        snSortOrder.addNode(NodePartType.SO_FIELD,getQueryBuilder().buildElement(element.getField(),nameSpace));
        snSortOrder.putValue(ValuePartType.SO_DIRECTION,element.getOrderDirection().toString());
        return snSortOrder;
    }

    @Override
    public QueryElementType getQueryElementType()
    {
        return QueryElementType.SORT_ORDER;
    }
}
