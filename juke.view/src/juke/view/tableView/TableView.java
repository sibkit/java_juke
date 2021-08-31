package juke.view.tableView;

import juke.events.EventEmitter;
import juke.view.View;
import juke.view.tableView.dataProvider.TableDataProvider;

import java.util.List;

public interface TableView extends View
{
    EventEmitter<SelectionChangedEventObject> getSelectionChangedEmitter();
    EventEmitter<CellValueChangeEventObject> getCellValueChangedEmitter();

    SelectionMode getSelectionMode();
    void setSelectionMode(SelectionMode mode);

    List<TableCell> getSelection();
    void setSelection(List<TableCell> selection);

    TableDataProvider getDataProvider();
    void setDataProvider(TableDataProvider dataProvider);
}
