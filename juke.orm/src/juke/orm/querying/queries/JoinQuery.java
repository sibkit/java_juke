package juke.orm.querying.queries;

import juke.orm.querying.QueryElementType;
import juke.orm.querying.conditions.Condition;

public class JoinQuery extends Query
{
    private JoinType joinType;
    private Condition onCondition;
    private Source leftSource;
    private Source rightSource;

    public JoinQuery(JoinType joinType)
    {
        this.joinType = joinType;
    }

    @Override
    public QueryElementType getElementType()
    {
        return QueryElementType.JOIN_QUERY;
    }

    public JoinType getJoinType()
    {
        return joinType;
    }
    public void setJoinType(JoinType joinType)
    {
        this.joinType = joinType;
    }

    public Condition getOnCondition()
    {
        return onCondition;
    }
    public void setOnCondition(Condition onCondition)
    {
        this.onCondition = onCondition;
        addChild(onCondition);
    }

    public Source getLeftSource()
    {
        return leftSource;
    }

    public void setLeftSource(Source leftSource)
    {
        this.leftSource = leftSource;
        addChild(leftSource);
    }

    public Source getRightSource()
    {
        return rightSource;
    }
    public void setRightSource(Source rightSource)
    {
        this.rightSource = rightSource;
        addChild(rightSource);
    }
}
