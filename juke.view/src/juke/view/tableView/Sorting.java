package juke.view.tableView;

import java.util.ArrayList;
import java.util.List;

public class Sorting
{
    public class SortInfo
    {
        private Object columnId;
        private SortDirection direction;

        public Object getColumnId()
        {
            return columnId;
        }

        public void setColumnId(Object columnId)
        {
            this.columnId = columnId;
        }

        public SortDirection getDirection()
        {
            return direction;
        }

        public void setDirection(SortDirection direction)
        {
            this.direction = direction;
        }
    }

    public enum SortDirection
    {
        ASC,
        DESC
    }
    private List<SortInfo> sortingInfo = new ArrayList<SortInfo>();

    public List<SortInfo> getSortingInfo()
    {
        return sortingInfo;
    }
}
