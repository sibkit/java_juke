package juke.view.tableView;


public interface TableCell
{
    Object getValue();
    String getSenseCode();

    Object getRowId();
    Object getColumnId();

    int getRowSpan();
    int getColumnSpan();

    Object getViewData();
    void setViewData(Object viewData);
}
