package juke.orm.jdbc.sql.nodebuilders;

import juke.orm.MappingData;
import juke.orm.jdbc.sql.NameTarget;
import juke.orm.jdbc.sql.node.NodeType;
import juke.orm.jdbc.sql.node.NodePartType;
import juke.orm.jdbc.sql.node.QueryNode;
import juke.orm.jdbc.sql.node.ValuePartType;
import juke.orm.mapping.FieldMap;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.fields.Field;
import juke.orm.querying.queries.EntityQuery;

import java.util.List;

public class EntityQueryNodeBuilder extends QueryNodeBuilder<EntityQuery>
{
    boolean isQuery(EntityQuery query)
    {
        if(query.getParentElement()==null)
            return true;
        if(query.getFields().size()>0)
            return true;
        if(query.getSortOrders().size()>0)
            return true;
        if(query.getLimit()>0)
            return true;
        if(query.getOffset()>0)
            return true;
        if(query.getCondition()!=null)
        {
            //if parent query is join then false and condition must be moved to parent query where clause
            return true;
        }
        return false;
    }


    @Override
    public QueryNode build(EntityQuery element, List<NameTarget> nameSpace)
    {
        QueryNode tableNode = new QueryNode(NodeType.TABLE);
        MappingData md = getQueryBuilder().getMappingData();

        tableNode.putValue(ValuePartType.T_NAME, md.getEntityMapper(element.getEntityName()).getMap().getTableName());
        if(isQuery(element))
        {
            QueryNode result = super.build(element, nameSpace);
            result.addNode(NodePartType.Q_FROM_SOURCE,tableNode);

            if(element.getFields().size()>0)
            {
                for(Field f : element.getFields())
                    result.addNode(NodePartType.Q_SELECT_FIELD,getQueryBuilder().buildElement(f,nameSpace));
            }
            else
            {
                for(FieldMap fm: md.getEntityMapper(element.getEntityName()).getMap().getFieldMaps())
                {
                    QueryNode fieldNode = new QueryNode(NodeType.LINK_FIELD);
                    fieldNode.putValue(ValuePartType.F_NAME,fm.getColumnName());
                    result.addNode(NodePartType.Q_SELECT_FIELD,fieldNode);
                }
            }

            return result;
        }
        return tableNode;
    }

    @Override
    public QueryElementType getQueryElementType()
    {
        return QueryElementType.ENTITY_QUERY;
    }
}
