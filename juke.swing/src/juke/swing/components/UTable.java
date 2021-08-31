package juke.swing.components;

import juke.swing.connectors.treeTableView.TreeTableCell;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.util.HashMap;
import java.util.Map;


public class UTable extends JTable
{
    private Map<String, TableCellRenderer> renderersMap = new HashMap<>();
    private Map<String, TableCellEditor> editorsMap = new HashMap<>();

    public UTable()
    {
        super();
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


    private DefaultCellEditor defaultCellEditor = new DefaultCellEditor(new JTextField());

    @Override
    public TableCellEditor getCellEditor(int row, int column)
    {
        USensedTableModel ttm = (USensedTableModel)getModel();
        String senseCode = ttm.getSenseCode(row,column);
        TableCellEditor editor = editorsMap.get(senseCode);
        return editor;
    }

    private DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

    @Override
    public TableCellRenderer getCellRenderer(int row, int column)
    {
        USensedTableModel ttm = (USensedTableModel)getModel();
        String senseCode = ttm.getSenseCode(row,column);
        TableCellRenderer renderer = renderersMap.get(senseCode);
        if(renderer!=null)
            return renderer;
        return defaultRenderer;
    }

    public Map<String, TableCellRenderer> getRenderersMap()
    {
        return renderersMap;
    }

    public Map<String, TableCellEditor> getEditorsMap()
    {
        return editorsMap;
    }
}
