package juke.view.tableView.dataProvider.operations;

import juke.view.tableView.dataProvider.DataChangeType;
import juke.view.tableView.dataProvider.DataChangedOperation;

public class RowAddedOperation extends DataChangedOperation
{
    private Object parentRowId;
    private int rowIndex;

    @Override
    public DataChangeType getChangeType()
    {
        return DataChangeType.ROWS_ADDED;
    }

    public int getRowIndex()
    {
        return rowIndex;
    }
    public void setRowIndex(int rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    public Object getParentRowId()
    {
        return parentRowId;
    }
    public void setParentRowId(Object parentRowId)
    {
        this.parentRowId = parentRowId;
    }
}
