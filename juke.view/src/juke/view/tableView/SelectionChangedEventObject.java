package juke.view.tableView;

import java.util.EventObject;
import java.util.List;

public class SelectionChangedEventObject extends EventObject
{
    private List<TableCell> selection;

    public SelectionChangedEventObject(Object source, List<TableCell> selection)
    {
        super(source);
        this.selection = selection;
    }

    public List<TableCell> getSelection()
    {
        return selection;
    }
}
