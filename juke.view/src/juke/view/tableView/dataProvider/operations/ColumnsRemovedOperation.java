package juke.view.tableView.dataProvider.operations;

import juke.view.tableView.dataProvider.DataChangeType;
import juke.view.tableView.dataProvider.DataChangedOperation;

public class ColumnsRemovedOperation extends DataChangedOperation
{
    @Override
    public DataChangeType getChangeType()
    {
        return DataChangeType.COLUMNS_REMOVED;
    }
}
