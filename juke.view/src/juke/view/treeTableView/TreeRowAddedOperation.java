package juke.view.treeTableView;

import juke.view.tableView.dataProvider.DataChangeType;
import juke.view.tableView.dataProvider.DataChangedOperation;

public class TreeRowAddedOperation extends DataChangedOperation
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

    public Object getParentRow()
    {
        return parentRowId;
    }
    public void setParentRow(Object parentRowId)
    {
        this.parentRowId = parentRowId;
    }
}
