package juke.view.tableView;

import java.util.EventObject;

public class CellValueChangeEventObject extends EventObject
{

    private TableCell tableCell;
    private Object newValue;
    private boolean veto = false;

    public CellValueChangeEventObject(Object source, TableCell tableCell, Object newValue)
    {
        super(source);
    }

    public TableCell getCell()
    {
        return tableCell;
    }

    public Object getNewValue()
    {
        return newValue;
    }

    public boolean isVeto()
    {
        return veto;
    }

    public void setVeto(boolean veto)
    {
        this.veto = veto;
    }
}
