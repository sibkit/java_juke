package juke.view.chartView;

import juke.view.View;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 01.12.12
 * Time: 10:11
 * To change this template use File | Settings | File Templates.
 */
public interface ChartView extends View
{
	List<ChartViewItem> getItems();
	void setItems(List<ChartViewItem> items, String seriesCaption);
}
