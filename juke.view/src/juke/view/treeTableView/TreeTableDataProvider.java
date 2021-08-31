package juke.view.treeTableView;

import juke.events.EventEmitter;
import juke.view.tableView.Sorting;
import juke.view.tableView.TableCell;
import juke.view.tableView.dataProvider.DataChangedEventObject;

public interface TreeTableDataProvider
{
    EventEmitter<DataChangedEventObject> getDataChangedEmitter();

    Sorting getSorting();
    void setSorting(Sorting sorting);

    int getColumnsCount();
    Object getColumnId(int index);

    String getColumnName(Object columnId);

    TableCell getCell(Object rowId, Object columnId);

    Object getParentRowId(Object rowId);
    int getIndexInParent(Object rowId);
    int getRowsCount(Object parentRowId);
    Object getRowId(Object parentRowId, int index);

}
