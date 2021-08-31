package juke.view.tableView.dataProvider;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class DataChangedEventObject extends EventObject
{
    private List<DataChangedOperation> dataChangeOperations;

    public DataChangedEventObject(Object source)
    {
        super(source);
    }

    public List<DataChangedOperation> getDataChangeOperations()
    {
        return dataChangeOperations;
    }

    public void setDataChangeOperations(List<DataChangedOperation> dataChangeOperations)
    {
        this.dataChangeOperations = dataChangeOperations;
    }
}
