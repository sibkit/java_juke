package juke.swing.common.tree;

import juke.common.ChargingList;

import java.util.List;

public class ExpandNode<T>
{
    private List<ExpandNode<T>> expandNodes = new ChargingList<ExpandNode<T>>() {
        @Override
        protected void charge(ExpandNode element)
        {
            element.parentNode = ExpandNode.this;
        }

        @Override
        protected void discharge(ExpandNode element)
        {
            element.parentNode = null;
        }
    };
    private ExpandNode parentNode;
    private T item;
    private int flatSize = 0;
    private boolean expanded = false;

    public List<ExpandNode<T>> getChildNodes()
    {
        return expandNodes;
    }
    public ExpandNode<T> getParentNode()
    {
        return parentNode;
    }

    public int getFlatSize()
    {
        return flatSize;
    }
    public void setFlatSize(int flatSize)
    {
        this.flatSize = flatSize;
    }

    public boolean isExpanded()
    {
        return expanded;
    }
    public void setExpanded(boolean expanded)
    {
        this.expanded = expanded;
    }

    public T getItem()
    {
        return item;
    }
    public void setItem(T item)
    {
        this.item = item;
    }
}
