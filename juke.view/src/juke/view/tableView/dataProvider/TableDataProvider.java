package juke.view.tableView.dataProvider;

import juke.events.EventEmitter;
import juke.view.tableView.Sorting;
import juke.view.tableView.TableCell;


public interface TableDataProvider
{
    EventEmitter getDataChangedEmitter();
    EventEmitter getRefreshedEmitter();

    Sorting getSorting();
    void setSorting(Sorting sorting);


    int getRowsCount();
    Object getRowId(int index);

    int getColumnsCount();
    Object getColumnId(int index);

    String getColumnName(Object columnId);

    TableCell getCell(Object rowId, Object columnId);
}
