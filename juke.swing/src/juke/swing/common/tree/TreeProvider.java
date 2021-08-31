package juke.swing.common.tree;

import juke.events.EventEmitter;

import java.util.EventObject;

public interface TreeProvider<T>
{
    T getParentItem(T item);
    int getIndexInParent(T item);
    int getChildItemsCount(T item);
    T getItem(T parent, int index);
}
