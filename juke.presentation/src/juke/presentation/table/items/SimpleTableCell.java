package juke.presentation.table.items;

import juke.view.tableView.TableCell;

public class SimpleTableCell implements TableCell
{
    private Object value;
    private String formatCode;
    private Object rowId;
    private Object columnId;
    private int rowSpan = 1;
    private int columnSpan = 1;
    private Object viewData;

    @Override
    public Object getValue()
    {
        return value;
    }

    @Override
    public String getSenseCode()
    {
        return formatCode;
    }

    @Override
    public Object getRowId()
    {
        return rowId;
    }

    @Override
    public Object getColumnId()
    {
        return columnId;
    }

    @Override
    public int getRowSpan()
    {
        return rowSpan;
    }

    @Override
    public int getColumnSpan()
    {
        return columnSpan;
    }

    @Override
    public Object getViewData()
    {
        return viewData;
    }

    @Override
    public void setViewData(Object viewData)
    {
        this.viewData = viewData;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public void setFormatCode(String formatCode)
    {
        this.formatCode = formatCode;
    }

    public void setRowId(Object rowId)
    {
        this.rowId = rowId;
    }

    public void setColumnId(Object columnId)
    {
        this.columnId = columnId;
    }

    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }

    public void setColumnSpan(int columnSpan)
    {
        this.columnSpan = columnSpan;
    }


}
