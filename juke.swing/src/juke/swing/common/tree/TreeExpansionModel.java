package juke.swing.common.tree;

import juke.events.BaseEventEmitter;
import juke.exceptions.JukeException;


import java.util.Comparator;
import java.util.EventObject;

public class TreeExpansionModel<T>
{
    private TreeProvider<T> treeProvider;
    private ExpandNode<T> rootExpandNode;

    private BaseEventEmitter<EventObject> expandStateChangedEmitter = new BaseEventEmitter<EventObject>();

    public int getFlatSize()
    {
        return rootExpandNode.getFlatSize();
    }

    public TreeExpansionModel(TreeProvider<T> treeProvider)
    {
        rootExpandNode = new ExpandNode();
        rootExpandNode.setExpanded(true);

        this.setTreeModel(treeProvider);

        rootExpandNode.setFlatSize(treeProvider.getChildItemsCount(null));
    }

    public boolean isExpanded(T item)
    {
        ExpandNode en = getExpandNode(item);
        if(en==null)
            return false;
        return en.isExpanded();
    }

    private ExpandNode<T> findExpandNode(ExpandNode<T> curNode, T item)
    {
        if(item.equals(curNode.getItem()))
            return curNode;
        for(ExpandNode<T> en : curNode.getChildNodes())
        {
            ExpandNode result = findExpandNode(en, item);
            if(result!=null)
                return result;
        }
        return null;
    }

    private ExpandNode<T> getExpandNode(T item)
    {
        return findExpandNode(rootExpandNode, item);
    }

    public void refresh()
    {
        rootExpandNode = new ExpandNode();
    }

    private void appendFlatSize(ExpandNode node, int size)
    {
        node.setFlatSize(node.getFlatSize()+size);
        if(node.getParentNode()!=null)
            appendFlatSize(node.getParentNode(),size);
    }

    private int calculateFlatSize(ExpandNode<T> eNode)
    {
        int result = 0;
        if(eNode.isExpanded())
        {
            result+= treeProvider.getChildItemsCount(eNode.getItem());
            for(ExpandNode<T> childNode : eNode.getChildNodes())
                result+=calculateFlatSize(childNode);
        }
        return result;
    }

    public void expand(T item)
    {
        ExpandNode<T> eNode = getExpandNode(item);
        if(eNode!=null)
        {
            if(eNode.isExpanded())
                throw new JukeException("TreeExpansionModel: expand");

            eNode.setExpanded(true);
            appendFlatSize(eNode, calculateFlatSize(eNode));
            return;
        }

        T parent = treeProvider.getParentItem(item);
        ExpandNode<T> enParent;

        enParent = (parent == null) ? rootExpandNode :getExpandNode(parent);

        eNode = new ExpandNode<T>();
        eNode.setExpanded(true);
        eNode.setItem(item);
        enParent.getChildNodes().add(eNode);
        appendFlatSize(eNode, treeProvider.getChildItemsCount(item));

        sortExpandNode(eNode.getParentNode());
        expandStateChangedEmitter.emit(new EventObject(this));
    }

    private void sortExpandNode(ExpandNode<T> node)
    {
        node.getChildNodes().sort(new Comparator<ExpandNode<T>>() {
            @Override
            public int compare(ExpandNode<T> o1, ExpandNode<T> o2)
            {
                int o1Index = treeProvider.getIndexInParent(o1.getItem());
                int o2Index = treeProvider.getIndexInParent(o2.getItem());
                return o1Index-o2Index;
            }
        });
        for(ExpandNode<T> cn : node.getChildNodes())
            sortExpandNode(cn);
    }

    public void collapse(T rowId)
    {
        ExpandNode en = getExpandNode(rowId);
        if(!en.isExpanded())
            throw new JukeException("TreeExpansionModel: collapse");

        en.setExpanded(false);
        appendFlatSize(en,-1*en.getFlatSize());
        expandStateChangedEmitter.emit(new EventObject(this));
    }

    public Object getRowIdByFlatIndex(int flatIndex)
    {
        if(rootExpandNode.getFlatSize()<flatIndex)
            throw new JukeException("TreeExpansionModel: getRowByFlatIndex");
        return findRowId(flatIndex,-1, rootExpandNode);
    }

    private T findRowId(int flatIndex, int parentFlatIndex, ExpandNode<T> parentNode)
    {
        if(parentNode.getChildNodes().size()==0)
            return treeProvider.getItem(parentNode.getItem(),flatIndex-parentFlatIndex-1);
        else
        {
            int curIndex = flatIndex-parentFlatIndex-1;
            int delta=0;
            for(ExpandNode<T> en : parentNode.getChildNodes())
            {
                int iip = treeProvider.getIndexInParent(en.getItem());
                int enFlatIndex = parentFlatIndex+iip+1+delta;
                if(enFlatIndex==flatIndex)
                    return parentNode.getItem();

                if(!en.isExpanded())
                    continue;


                if(enFlatIndex>=flatIndex)
                    return treeProvider.getItem(parentNode.getItem(), curIndex-delta);
                else
                {
                    if(enFlatIndex+en.getFlatSize()>=flatIndex)
                        return findRowId(flatIndex,enFlatIndex,en);
                    delta+=en.getFlatSize();
                }
            }
            return treeProvider.getItem(parentNode.getItem(),curIndex-delta);
        }
    }

    public void notifyRemoveItem(T item)
    {
        ExpandNode en = getExpandNode(item);
        if(en==null)
        {
            T pRowId = treeProvider.getParentItem(item);
            if(pRowId == null)
            {
                appendFlatSize(rootExpandNode, -1);
            }
            else
            {
                en = getExpandNode(pRowId);
                if(en!=null)
                {
                    appendFlatSize(en, -1);
                   // modelChangedEmitter.emit(new EventObject(this));
                }
            }
        }
        else
        {
            ExpandNode enParent = en.getParentNode();
            enParent.getChildNodes().remove(en);
            appendFlatSize(enParent, -1*en.getFlatSize());
        }
    }

    public void notifyAddItem(T rowId)
    {
        T pRowId = treeProvider.getParentItem(rowId);
        ExpandNode enParent;
        if(pRowId==null)
            enParent = rootExpandNode;
        else
            enParent = getExpandNode(pRowId);
        if(enParent!=null)
        {
            appendFlatSize(enParent, 1);
            //modelChangedEmitter.emit(new EventObject(this));
        }
    }

    public TreeProvider getTreeModel()
    {
        return treeProvider;
    }

    public void setTreeModel(TreeProvider treeProvider)
    {
        this.treeProvider = treeProvider;
    }

    public BaseEventEmitter getExpandStateChangedEmitter()
    {
        return expandStateChangedEmitter;
    }
}
