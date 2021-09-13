package juke.common;

public class ChildList<P,T extends Child<? super P>> extends ChargingList<T>
{
    private P owner;

    public ChildList(P owner)
    {
        this.owner = owner;
    }

    @Override
    protected void charge(T element)
    {
        element.setParent(owner);
    }

    @Override
    protected void discharge(T element)
    {
        element.setParent(null);
    }

    public P getOwner()
    {
        return owner;
    }

    public void setOwner(P owner)
    {
        this.owner = owner;
        for(T element : super.list)
            charge(element);
    }

}
