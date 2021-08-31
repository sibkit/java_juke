package juke.swing.connectors.tableView;

import juke.view.tableView.TableCell;
import juke.view.tableView.dataProvider.TableDataProvider;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class UTableModel implements TableModel
{
    private TableDataProvider dataProvider;
    List<TableModelListener> modelListeners = new ArrayList<>();

    @Override
    public int getRowCount()
    {
        return dataProvider.getRowsCount();
    }

    @Override
    public int getColumnCount()
    {
        return dataProvider.getColumnsCount();
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        return dataProvider.getColumnName(dataProvider.getColumnId(columnIndex));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object rowId = dataProvider.getRowId(rowIndex);
        Object colId = dataProvider.getColumnId(columnIndex);
        TableCell cell = dataProvider.getCell(rowId,colId);
        return cell;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        System.out.println("setValueAt: "+aValue);
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
        modelListeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
        modelListeners.remove(l);
    }

    public void fireChange()
    {
        TableModelEvent tme = new TableModelEvent(this);
        for(TableModelListener tml: modelListeners)
            tml.tableChanged(tme);
    }

    public void setDataProvider(TableDataProvider dataProvider)
    {
        this.dataProvider = dataProvider;
        fireChange();
    }
}
