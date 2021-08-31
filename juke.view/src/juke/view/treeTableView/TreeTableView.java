package juke.view.treeTableView;

import juke.events.EventEmitter;
import juke.view.View;
import juke.view.tableView.SelectionMode;
import juke.view.tableView.TableCell;

import java.util.List;

public interface TreeTableView extends View
{
    EventEmitter getSelectionChangedEmitter();
    EventEmitter getCellChangedEmitter();

    SelectionMode getSelectionMode();
    void setSelectionMode(SelectionMode mode);

    List<TableCell> getSelection();
    void setSelection(List<TableCell> selection);

    TreeTableDataProvider getDataProvider();
    void setDataProvider(TreeTableDataProvider dataProvider);
}
