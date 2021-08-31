package juke.swing.connectors.treeTableView;


import juke.events.EventHandler;
import juke.swing.common.tree.TreeExpansionModel;
import juke.swing.common.tree.TreeProvider;
import juke.swing.components.USensedTableModel;

import juke.view.tableView.TableCell;
import juke.view.treeTableView.TreeTableDataProvider;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class UTreeTableModel implements USensedTableModel
{
    private TreeTableDataProvider dataProvider;
    private TreeExpansionModel treeExpansionModel;
    List<TableModelListener> modelListeners = new ArrayList<>();

    @Override
    public int getRowCount()
    {
        return getTreeExpansionModel().getFlatSize();
    }

    @Override
    public int getColumnCount()
    {
        return getDataProvider().getColumnsCount();
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        return getDataProvider().getColumnName(getDataProvider().getColumnId(columnIndex));
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
        Object rowId = getTreeExpansionModel().getRowIdByFlatIndex(rowIndex);
        Object colId = dataProvider.getColumnId(columnIndex);
        TableCell cell = dataProvider.getCell(rowId,colId);
        return cell;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        System.out.println("setValueAt: "+aValue);
    }

    public void fireChange()
    {
        TableModelEvent tme = new TableModelEvent(this);
        for(TableModelListener tml: modelListeners)
            tml.tableChanged(tme);
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

    public TreeTableDataProvider getDataProvider()
    {
        return dataProvider;
    }

    public void setDataProvider(TreeTableDataProvider dataProvider)
    {
        this.dataProvider = dataProvider;
        treeExpansionModel = new TreeExpansionModel(new TreeProvider() {
            @Override
            public Object getParentItem(Object item)
            {
                return dataProvider.getParentRowId(item);
            }

            @Override
            public int getIndexInParent(Object item)
            {
                return dataProvider.getIndexInParent(item);
            }

            @Override
            public int getChildItemsCount(Object item)
            {
                return dataProvider.getRowsCount(item);
            }

            @Override
            public Object getItem(Object parent, int index)
            {
                return dataProvider.getRowId(parent,index);
            }
        });
        getTreeExpansionModel().getExpandStateChangedEmitter().addHandler(new EventHandler() {
            @Override
            public void handle(EventObject event)
            {
                fireChange();
            }
        });
        fireChange();
    }

    public TreeExpansionModel getTreeExpansionModel()
    {
        return treeExpansionModel;
    }

    @Override
    public String getSenseCode(int row, int column)
    {
        Object rowId = getTreeExpansionModel().getRowIdByFlatIndex(row);
        Object colId = dataProvider.getColumnId(column);
        TableCell cell = dataProvider.getCell(rowId,colId);
        return cell.getSenseCode();
    }
}
