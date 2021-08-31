package juke.swing.connectors.treeTableView;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.swing.components.UTable;
import juke.view.tableView.SelectionMode;
import juke.view.tableView.TableCell;
import juke.view.treeTableView.TreeTableDataProvider;
import juke.view.treeTableView.TreeTableView;
import java.util.EventObject;
import java.util.List;

public class UTreeTableConnector implements TreeTableView
{
    private BaseEventEmitter<EventObject> dataProviderInstalledEmitter = new BaseEventEmitter<>();

    private UTable treeTable;
    private TreeTableDataProvider dataProvider;

    public UTreeTableConnector(UTable treeTable)
    {
        this.treeTable = treeTable;
    }

    @Override
    public EventEmitter getSelectionChangedEmitter()
    {
        return null;
    }

    @Override
    public EventEmitter getCellChangedEmitter()
    {
        return null;
    }

    @Override
    public SelectionMode getSelectionMode()
    {
        return null;
    }

    @Override
    public void setSelectionMode(SelectionMode mode)
    {

    }

    @Override
    public List<TableCell> getSelection()
    {
        return null;
    }

    @Override
    public void setSelection(List<TableCell> selection)
    {

    }



    @Override
    public TreeTableDataProvider getDataProvider()
    {
        return this.dataProvider;
    }

    @Override
    public void setDataProvider(TreeTableDataProvider tableDataProvider)
    {
        this.dataProvider = tableDataProvider;
        UTreeTableModel ttm = new UTreeTableModel();
        ttm.setDataProvider(tableDataProvider);
        this.treeTable.setModel(ttm);
        dataProviderInstalledEmitter.emit(new EventObject(this));
    }

    @Override
    public Boolean isVisible()
    {
        return treeTable.isVisible();
    }

    @Override
    public void setVisible(Boolean value)
    {
        treeTable.setVisible(value);
    }

    @Override
    public Boolean isEnabled()
    {
        return treeTable.isEnabled();
    }

    @Override
    public void setEnabled(Boolean value)
    {
        treeTable.setEnabled(value);
    }

    @Override
    public Object getUIObject()
    {
        return null;
    }

    public EventEmitter<EventObject> getDataProviderInstalledEmitter()
    {
        return dataProviderInstalledEmitter;
    }
}
