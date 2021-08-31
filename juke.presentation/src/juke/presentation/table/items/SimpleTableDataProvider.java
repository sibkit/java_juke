package juke.presentation.table.items;

import juke.events.EventEmitter;
import juke.view.tableView.Sorting;
import juke.view.tableView.dataProvider.TableDataProvider;
import juke.view.tableView.TableCell;


import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 26.10.12
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTableDataProvider implements TableDataProvider
{
	private Map<Object, List<TableCell>> cellsMap = new HashMap<>();

	private List<Object> rowIds;
	private List<Object> columnIds;

	private CellsProvider cellsProvider;

	@Override
	public TableCell getCell(Object rowId, Object columnId)
	{
		List<TableCell> cells = cellsMap.get(rowId);
		if (cells == null)
		{
			cells = new ArrayList<>();
			cellsMap.put(rowId, cells);
		}

		for (TableCell cell : cells)
			if (cell.getColumnId() == columnId)
				return cell;

		TableCell result = cellsProvider.getCell(rowId, columnId);
		cells.add(result);
		return result;
	}

	@Override
	public EventEmitter getDataChangedEmitter()
	{
		return null;
	}

	@Override
	public EventEmitter getRefreshedEmitter()
	{
		return null;
	}

	@Override
	public Sorting getSorting()
	{
		return null;
	}

	@Override
	public void setSorting(Sorting sorting)
	{

	}




	@Override
	public int getRowsCount()
	{
		return this.rowIds.size();
	}

	@Override
	public int getColumnsCount()
	{
		return this.columnIds.size();
	}

	@Override
	public Object getRowId(int index)
	{
		return rowIds.get(index);
	}

	@Override
	public Object getColumnId(int index)
	{
		return this.columnIds.get(index);
	}

	@Override
	public String getColumnName(Object columnId)
	{
		return ""+columnId;
	}

	public void update()
	{
		//emit(TableDataProvider.REFRESHED, new EventObject(this));
	}

	public CellsProvider getCellProvider()
	{
		return cellsProvider;
	}

	public void setCellProvider(CellsProvider cellsProvider)
	{
		this.cellsProvider = cellsProvider;
	}
}
