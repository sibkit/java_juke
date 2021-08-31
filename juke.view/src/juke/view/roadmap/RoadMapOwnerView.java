package juke.view.roadmap;

import juke.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 27.09.12
 * Time: 2:10
 * To change this template use File | Settings | File Templates.
 */
public interface RoadMapOwnerView extends View
{
	RoadMapView getRoadMapView();
	void setContentView(View contentView);
}
