package juke.orm.jdbc.sql.nodebuilders;

import juke.orm.jdbc.sql.NameTarget;
import juke.orm.jdbc.sql.node.NodePartType;
import juke.orm.jdbc.sql.node.NodeType;
import juke.orm.jdbc.sql.node.QueryNode;
import juke.orm.jdbc.sql.node.ValuePartType;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.conditions.Condition;
import juke.orm.querying.fields.Field;

import java.util.List;

public class ConditionNodeBuilder extends NodeBuilder<Condition>
{
    @Override
    public QueryNode build(Condition element, List<NameTarget> nameSpace)
    {
        QueryNode result = new QueryNode(NodeType.CONDITION);
        result.putValue(ValuePartType.C_TYPE, element.getConditionType());
        for(Condition c: element.getInnerConditions())
            result.addNode(NodePartType.C_CONDITION,getQueryBuilder().buildElement(c,nameSpace));
        for(Field f: element.getFields())
            result.addNode(NodePartType.C_FIELD,getQueryBuilder().buildElement(f,nameSpace));
        return result;
    }

    @Override
    public QueryElementType getQueryElementType()
    {
        return QueryElementType.CONDITION;
    }
}
