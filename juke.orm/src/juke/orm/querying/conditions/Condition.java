package juke.orm.querying.conditions;

import juke.common.ChildList;
import juke.orm.querying.QueryElement;
import juke.orm.querying.QueryElementType;
import juke.orm.querying.fields.Field;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 09.01.12
 * Time: 1:13
 * To change this juke.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */
public class Condition extends QueryElement
{
    private final ChildList<Condition, Condition> innerConditions = new ChildList<>(this);
    private final List<Field> fields = new ChildList<>(this);
    private final ConditionType conditionType;


    public Condition(ConditionType conditionType)
    {
        this.conditionType = conditionType;
    }

    public Condition(ConditionType conditionType, Field... fields)
    {
        this.conditionType = conditionType;
        this.fields.addAll(Arrays.asList(fields));
    }

    public List<Condition> getInnerConditions()
    {
        return innerConditions;
    }
    public List<Field> getFields()
    {
        return fields;
    }

    @Override
    public QueryElementType getElementType()
    {
        return QueryElementType.CONDITION;
    }
    public ConditionType getConditionType()
    {
        return conditionType;
    }
}
