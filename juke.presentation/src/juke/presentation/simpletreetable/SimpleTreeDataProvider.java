package juke.presentation.simpletreetable;


import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.presentation.table.items.CellsProvider;
import juke.presentation.table.items.SimpleTableColumn;
import juke.view.tableView.Sorting;
import juke.view.tableView.TableCell;
import juke.view.tableView.dataProvider.DataChangedEventObject;
import juke.view.treeTableView.TreeTableDataProvider;

import java.util.List;

public class SimpleTreeDataProvider implements TreeTableDataProvider
{
    private Sorting sorting;
    private List<SimpleTreeRow> rootRows;
    private List<SimpleTableColumn> columns;
    private CellsProvider cellsProvider;
    private BaseEventEmitter<DataChangedEventObject> dataChangedEmitter = new BaseEventEmitter<>();

    @Override
    public EventEmitter<DataChangedEventObject> getDataChangedEmitter()
    {
        return dataChangedEmitter;
    }

    @Override
    public Sorting getSorting()
    {
        return sorting;
    }

    @Override
    public void setSorting(Sorting sorting)
    {
        this.sorting = sorting;
    }

    @Override
    public int getRowsCount(Object parentRowId)
    {
        if(parentRowId==null)
        {
            if(rootRows==null)
                return 0;
            return rootRows.size();
        }
        return ((SimpleTreeRow)parentRowId).getChildRows().size();
    }

    @Override
    public Object getRowId(Object parentRowId, int index)
    {
        List<SimpleTreeRow> rows;
        if(parentRowId==null)
            rows = rootRows;
        else
            rows = ((SimpleTreeRow)parentRowId).getChildRows();
        return rows.get(index);
    }

    @Override
    public int getColumnsCount()
    {
        if(columns==null)
            return 0;
        return columns.size();
    }

    @Override
    public Object getColumnId(int index)
    {
        return columns.get(index);
    }

    @Override
    public String getColumnName(Object columnId)
    {
        SimpleTableColumn col = (SimpleTableColumn)columnId;
        return col.getName();
    }

    @Override
    public TableCell getCell(Object rowId, Object columnId)
    {
        return cellsProvider.getCell(rowId,columnId);
        /*
        SimpleTableCell result = new SimpleTableCell();
        result.setColumn(column);
        result.setRow(row);
        result.setColumnSpan(1);
        result.setRowSpan(1);

        switch(column.getName())
        {
            case "":
                break;
        }

        //if(column instanceof SimpleTableColumn)
        //{
         //   SimpleTableColumn stc = (SimpleTableColumn)column;
         //   stc.getCellBinder().bindToCell(row,result);
        //}
        result.setFormatCode("STRING");
        return result;*/
    }

    @Override
    public Object getParentRowId(Object rowId)
    {
        return ((SimpleTreeRow)rowId).parentRow;
    }

    @Override
    public int getIndexInParent(Object rowId)
    {
        SimpleTreeRow str = (SimpleTreeRow)rowId;

        if(str.parentRow==null)
            return rootRows.indexOf(rowId);
        else
        {
            SimpleTreeRow parentRow = str.parentRow;
            return parentRow.getChildRows().indexOf(str);
        }
    }


    public List<SimpleTreeRow> getRootRows()
    {
        return rootRows;
    }

    public void setRootRows(List<SimpleTreeRow> rootRows)
    {
        this.rootRows = rootRows;
    }
    public void setColumns(List<SimpleTableColumn> columns)
    {
        this.columns = columns;
    }


    public CellsProvider getCellsProvider()
    {
        return cellsProvider;
    }

    public void setCellsProvider(CellsProvider cellsProvider)
    {
        this.cellsProvider = cellsProvider;
    }
}

