package juke.view.roadmap;

import juke.view.View;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 26.09.12
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public interface RoadMapView extends View
{
	List<RoadMapItem> getItems();
	void setItems(List<RoadMapItem> items);
}
