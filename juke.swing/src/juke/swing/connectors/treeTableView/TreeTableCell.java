package juke.swing.connectors.treeTableView;

import juke.swing.common.tree.TreeExpansionModel;
import juke.swing.connectors.treeTableView.UTreeTableModel;
import juke.view.tableView.TableCell;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.EventObject;

public class TreeTableCell extends JComponent implements TableCellRenderer, TableCellEditor, Serializable
{


    TreeExpansionModel expansionModel;


    public TreeTableCell(TreeExpansionModel expansionModel)
    {
        super();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                //selectCell(e);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
        //this.setFocusable(false);
        this.expansionModel = expansionModel;
    }

    private void selectCell(MouseEvent e)
    {
        Point pScreen = e.getLocationOnScreen();
        Point pScreenTable = table.getLocationOnScreen();
        Point pTable = new Point(pScreen.x - pScreenTable.x,pScreen.y-pScreenTable.y);


        int row = table.rowAtPoint(pTable);
        int column = table.columnAtPoint(pTable);
        //rect = table.getCellRect(row, column, true);

        //table.getCo
        table.setRowSelectionInterval(row, row);
    }

    @Override
    protected void processMouseEvent(MouseEvent e)
    {
        if(e.getID()==MouseEvent.MOUSE_PRESSED)
        {
            isExpanded = expansionModel.isExpanded(rowId);
            if(arrowIcon != null)
            {
                int iconX = getArrowIconX();
                if(e.getX()>=iconX && e.getX()<=iconX+arrowIcon.getIconWidth())
                {
                    UTreeTableModel model = (UTreeTableModel) table.getModel();
                    if(isExpanded)
                        model.getTreeExpansionModel().collapse(rowId);
                    else
                        model.getTreeExpansionModel().expand(rowId);

                    isExpanded = !isExpanded;
                    if(isExpanded)
                        arrowIcon = (Icon)UIManager.getLookAndFeelDefaults().get("Tree.expandedIcon");
                    else
                        arrowIcon = (Icon)UIManager.getLookAndFeelDefaults().get("Tree.collapsedIcon");
                    model.fireChange();
                    //repaint();
                }
                else
                {
                    selectCell(e);
                }
            }
            stopCellEditing();
            //table.removeEditor();
            //table.setCellEditor(null);
        }
        super.processMouseEvent(e);
    }

    boolean hasChild;
    Object value;
    boolean isExpanded;

    private int flatIndex;
    private Insets margin;
    private int leftCI;
    private int rightCI;
    private Icon arrowIcon;
    private int rowLevel;

    boolean isSelected;

    int column;
    private Object rowId;

    private JTable table;

    private int getRowLevel(Object rowId)
    {
        int result = 0;

        Object parentRowId = expansionModel.getTreeModel().getParentItem(rowId);
        while(parentRowId!=null)
        {
            result++;
            parentRowId = expansionModel.getTreeModel().getParentItem(parentRowId);
        }

        return result;
    }



    void prepareComponent(JTable table, Object value, boolean isSelected, int rowIndex, int column)
    {

        this.setFont(table.getFont());
        if(!isSelected)
        {
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }
        else
        {
            this.setBackground(table.getSelectionBackground());
            this.setForeground(table.getSelectionForeground());
        }
        this.table = table;
        this.flatIndex = rowIndex;
        this.value = value;
        this.isSelected = isSelected;
        //this.hasFocus = hasFocus;
        this.column = column;
        this.rowId = expansionModel.getRowIdByFlatIndex(flatIndex);
        this.rowLevel = getRowLevel(rowId);
        hasChild = expansionModel.getTreeModel().getChildItemsCount(rowId)>0;
        isExpanded = expansionModel.isExpanded(rowId);

        leftCI = (Integer) UIManager.getLookAndFeelDefaults().get("Tree.leftChildIndent");
        rightCI = (Integer) UIManager.getLookAndFeelDefaults().get("Tree.rightChildIndent");

        margin = (Insets)UIManager.getLookAndFeelDefaults().get("CheckBox.margin");

        //int gap = (Integer) UIManager.getLookAndFeelDefaults().get("Button.iconTextGap");// LayoutStyle.getInstance().getPreferredGap(null,null, LayoutStyle.ComponentPlacement.INDENT,0,this);

        int textIconGap = (Integer)UIManager.getLookAndFeelDefaults().get("Button.textIconGap");

        if(hasChild)
        {
            if(isExpanded)
                arrowIcon = (Icon)UIManager.getLookAndFeelDefaults().get("Tree.expandedIcon");
            else
                arrowIcon = (Icon)UIManager.getLookAndFeelDefaults().get("Tree.collapsedIcon");
        }
        else
            arrowIcon = null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int column)
    {
        prepareComponent(table,value,isSelected,rowIndex,column);
        return this;
    }

    int getArrowIconX()
    {
        return margin.left + (leftCI + rightCI) * rowLevel + leftCI - arrowIcon.getIconWidth() / 2;
    }

    int getArrowIconY()
    {
        return (getHeight() - arrowIcon.getIconHeight()) / 2;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);


        TableCell cell = (TableCell)value;
        FontMetrics fm = g.getFontMetrics();
        int tx = fm.getAscent()-fm.getDescent();
        g.setColor(getBackground());
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(getForeground());
        g.drawString(""+cell.getValue(),margin.left+(leftCI+rightCI)*(rowLevel+1),(getHeight()+tx)/2);
        if(arrowIcon!=null)
        {
            arrowIcon.paintIcon(this, g, getArrowIconX(), getArrowIconY());
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int column)
    {
        System.out.println("getTableCellEditorComponent");

        prepareComponent(table,value,isSelected,rowIndex,column);
        table.setRowSelectionInterval(rowIndex,rowIndex);
        this.setBackground(Color.orange);
        return this;
    }

    @Override
    public Object getCellEditorValue()
    {
        return value;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent)
    {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent)
    {
        System.out.println("shouldSelectCell");
        return false;
    }

    /**
     * The list of listeners.
     */
    protected EventListenerList listenerList = new EventListenerList();
    /**
     * The change event.
     */
    protected transient ChangeEvent changeEvent = null;

    // Force this to be implemented.
    // public Object  getCellEditorValue()



    /**
     * Calls <code>fireEditingStopped</code> and returns true.
     * @return true
     */
    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }

    /**
     * Calls <code>fireEditingCanceled</code>.
     */
    public void  cancelCellEditing() {
        fireEditingCanceled();
    }

    /**
     * Adds a <code>CellEditorListener</code> to the listener list.
     * @param l  the new listener to be added
     */
    public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }

    /**
     * Removes a <code>CellEditorListener</code> from the listener list.
     * @param l  the listener to be removed
     */
    public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }

    /**
     * Returns an array of all the <code>CellEditorListener</code>s added
     * to this AbstractCellEditor with addCellEditorListener().
     *
     * @return all of the <code>CellEditorListener</code>s added or an empty
     *         array if no listeners have been added
     * @since 1.4
     */
    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }

    /**
     * Notifies all listeners that have registered interest for
     * notification on this event type.  The event instance
     * is created lazily.
     *
     * @see EventListenerList
     */
    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null)
                    changeEvent = new ChangeEvent(this);
                ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
            }
        }
    }

    /**
     * Notifies all listeners that have registered interest for
     * notification on this event type.  The event instance
     * is created lazily.
     *
     * @see EventListenerList
     */
    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null)
                    changeEvent = new ChangeEvent(this);
                ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
            }
        }
    }
}
