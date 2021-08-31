package juke.presentation.simpletreetable;

import juke.common.ChargingList;

import java.util.List;

public class SimpleTreeRow
{
    private Object item;

    SimpleTreeRow parentRow;
    private List<SimpleTreeRow> childRows = new ChargingList<SimpleTreeRow>() {
        @Override
        protected void charge(SimpleTreeRow element)
        {
            element.parentRow = SimpleTreeRow.this;
        }

        @Override
        protected void discharge(SimpleTreeRow element)
        {
            element.parentRow = null;
        }
    };

    public List<SimpleTreeRow> getChildRows()
    {
        return childRows;
    }

    public Object getItem()
    {
        return item;
    }

    public void setItem(Object item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "SimpleTreeRow{" +
            "item=" + item +
            '}';
    }
}