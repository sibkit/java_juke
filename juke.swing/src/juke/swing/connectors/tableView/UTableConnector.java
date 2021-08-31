package juke.swing.connectors.tableView;

import juke.events.BaseEventEmitter;
import juke.events.EventEmitter;
import juke.swing.components.UTable;
import juke.swing.connectors.Connector;
import juke.view.tableView.*;
import juke.view.tableView.dataProvider.TableDataProvider;

import java.util.EventObject;
import java.util.List;

public class UTableConnector extends Connector<UTable> implements TableView
{
    //private UTable table;

    private BaseEventEmitter<SelectionChangedEventObject> selectionChangedEmitter = new BaseEventEmitter<>();
    private BaseEventEmitter<CellValueChangeEventObject> cellValueChangedEmitter = new BaseEventEmitter<>();
    private BaseEventEmitter<EventObject> dataProviderInstalledEmitter = new BaseEventEmitter<>();


    private TableDataProvider dataProvider;


    public UTableConnector(UTable table)
    {
        super(table);
        //this.table = table;
    }

    @Override
    public EventEmitter<SelectionChangedEventObject> getSelectionChangedEmitter()
    {
        return selectionChangedEmitter;
    }

    @Override
    public EventEmitter<CellValueChangeEventObject> getCellValueChangedEmitter()
    {
        return cellValueChangedEmitter;
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
    public TableDataProvider getDataProvider()
    {
        return dataProvider;
    }

    @Override
    public void setDataProvider(TableDataProvider dataProvider)
    {
        this.dataProvider = dataProvider;
        UTableModel tm = new UTableModel();
        tm.setDataProvider(dataProvider);
        getComponent().setModel(tm);
        dataProviderInstalledEmitter.emit(new EventObject(this));
    }

    @Override
    public Boolean isVisible()
    {
        return getComponent().isVisible();
    }

    @Override
    public void setVisible(Boolean value)
    {
        this.getComponent().setVisible(value);
    }

    @Override
    public Boolean isEnabled()
    {
        return getComponent().isEnabled();
    }

    @Override
    public void setEnabled(Boolean value)
    {
        getComponent().setEnabled(value);
    }

    @Override
    public Object getUIObject()
    {
        return null;
    }
}
