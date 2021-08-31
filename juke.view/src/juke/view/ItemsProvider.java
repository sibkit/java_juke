package juke.view;

public interface ItemsProvider<T>
{
    Integer getItemsCount();
    T[] getItems(int startIndex, int count);
}
