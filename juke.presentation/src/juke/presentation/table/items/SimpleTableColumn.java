package juke.presentation.table.items;


public class SimpleTableColumn
{
    private String columnName;

    public SimpleTableColumn(String name)
    {
        this.columnName = name;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getName()
    {
        return columnName;
    }
}
