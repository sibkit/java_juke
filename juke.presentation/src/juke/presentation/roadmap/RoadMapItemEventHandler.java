package juke.presentation.roadmap;

import juke.common.TreeNode;
import juke.events.EventHandler;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 27.09.12
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public class RoadMapItemEventHandler implements EventHandler<EventObject>
{
	TreeNode<ContentController> node;
	MasterController presenter;

	public RoadMapItemEventHandler(TreeNode<ContentController> node, MasterController presenter)
	{
		this.node = node;
		this.presenter = presenter;
	}

	@Override
	public void handle(EventObject event)
	{
		this.presenter.transmit(node.getItem().getKey(),null);
	}
}
