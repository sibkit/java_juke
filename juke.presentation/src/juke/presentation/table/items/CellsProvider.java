package juke.presentation.table.items;

import juke.view.tableView.TableCell;

public interface CellsProvider
{
    TableCell getCell(Object rowId, Object columnId);
}

