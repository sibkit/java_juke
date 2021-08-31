package juke.orm.querying;

import juke.common.ChargingList;

/**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 25.01.12
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class QueryElementList<T extends QueryElement> extends ChargingList<T>
{
    private QueryElement owner;
    public QueryElementList(QueryElement owner)
    {
        this.setOwner(owner);
    }

    @Override
    protected void charge(T element)
    {
        getOwner().addChild(element);
    }

    @Override
    protected void discharge(T element)
    {
        element.removeChild(element);
    }

    public QueryElement getOwner()
    {
        return owner;
    }

    public void setOwner(QueryElement owner)
    {
        this.owner = owner;
        for(T element : super.list)
            charge(element);
    }
}
