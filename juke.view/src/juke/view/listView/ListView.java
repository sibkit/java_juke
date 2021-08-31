package juke.view.listView;

import juke.events.EventEmitter;
import juke.view.View;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 04.10.12
 * Time: 4:29
 * To change this template use File | Settings | File Templates.
 */
public interface ListView extends View
{
	EventEmitter getSelectionChangedEmitter();
	List<ListViewItem> getItems();
	void setItems(List<ListViewItem> items);
	List<ListViewItem> getSelection();
	void setSelection(List<ListViewItem> items);
	void setSelection(ListViewItem item);
}
