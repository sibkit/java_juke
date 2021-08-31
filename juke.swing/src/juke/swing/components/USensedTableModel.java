package juke.swing.components;

import javax.swing.table.TableModel;

public interface USensedTableModel extends TableModel
{
    String getSenseCode(int row, int column);
}
