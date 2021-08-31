package juke.common;

import java.util.List;

public class TreeNode<T>
{
    private T item;
    private TreeNode<T> parentNode;
    private List<TreeNode<T>> childNodes;

    public TreeNode(T item)
    {
        this();
        this.item = item;
    }

    public TreeNode()
    {
        childNodes = new ChargingList<TreeNode<T>>()
        {
            @Override
            protected void charge(TreeNode<T> element)
            {
                element.parentNode = TreeNode.this;
            }

            @Override
            protected void discharge(TreeNode<T> element)
            {
                element.parentNode = null;
            }
        };
    }

    public T getItem()
    {
        return item;
    }

    public void setItem(T item)
    {
        this.item = item;
    }

    public TreeNode<T> getParentNode()
    {
        return parentNode;
    }

    public List<TreeNode<T>> getChildNodes()
    {
        return childNodes;
    }
}
