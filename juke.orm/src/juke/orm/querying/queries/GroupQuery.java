package juke.orm.querying.queries;

import juke.orm.querying.QueryElementList;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.fields.Field;

import java.util.List;

public class GroupQuery extends Query
{
    private List<Field> groupFields = new QueryElementList<>(this);
    private Source source;

    public List<Field> getGroupFields()
    {
        return groupFields;
    }

    @Override
    public QueryElementType getElementType()
    {
        return QueryElementType.GROUP_QUERY;
    }

    public Source getSource()
    {
        return source;
    }
    public void setSource(Source source)
    {
        this.source = source;
        addChild(source);
    }
}
