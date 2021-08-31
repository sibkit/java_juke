package juke.presentation.roadmap;

import juke.common.TreeNode;
import juke.events.EventHandler;
import juke.presentation.BaseController;
import juke.view.roadmap.RoadMapOwnerView;
import juke.view.roadmap.RoadMapItem;
import juke.view.roadmap.RoadMapView;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 26.09.12
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class MasterController<T extends RoadMapOwnerView> extends BaseController<T>
{
	private Map<Object,TreeNode<ContentController>> nodesByKeyMap;

	public MasterController(T view)
	{
		setView(view);
		transmit(getMap().getItem().getKey(),null);
	}

	void fillKeyMap(TreeNode<ContentController> node)
	{
		if(node.getItem().getKey()!=null)
		{
			getNodesByKeyMap().put(node.getItem().getKey(),node);
		}
		for(TreeNode<ContentController> cn : node.getChildNodes())
			fillKeyMap(cn);
	}



	Map<Object,TreeNode<ContentController>> getNodesByKeyMap()
	{
		if(nodesByKeyMap==null)
			nodesByKeyMap = new HashMap<>();
		return nodesByKeyMap;
	}

	public TreeNode<ContentController> getNode(Object key)
	{
		return getNodesByKeyMap().get(key);
	}

	TreeNode<ContentController> map;
	public abstract RoadMapView getRoadMapView();
	public abstract TreeNode<ContentController> createMap();
	public TreeNode<ContentController> getMap()
	{
		if(map==null)
		{
			map = createMap();
			fillKeyMap(map);
		}
		return map;
	}

	List<RoadMapItem> createRoadMapItems(TreeNode<ContentController> node)
	{
		List<RoadMapItem> result = new ArrayList<>();
		TreeNode<ContentController> cursorNode = node;
		while (cursorNode!=null)
		{
			final RoadMapItem item = new RoadMapItem();
			item.setText(cursorNode.getItem().getViewCaption());


			final TreeNode<ContentController> cnHandle = cursorNode;
			cursorNode.getItem().getCaptionChangedEmitter().addHandler(new EventHandler<EventObject>()
			{
				@Override
				public void handle(EventObject event)
				{
					item.setText(cnHandle.getItem().getViewCaption());
				}
			});
			item.getNotifyEmitter().addHandler(new RoadMapItemEventHandler(cursorNode,this));
			cursorNode = cursorNode.getParentNode();
			result.add(0,item);
		}
		return result;
	}

	void prepareRoadMapView(TreeNode<ContentController> node)
	{
		RoadMapView rmv = getRoadMapView();
		rmv.setItems(createRoadMapItems(node));
	}

	TreeNode<ContentController> activeNode;

	public void transmit(Object receiverKey,Object data)
	{
		if(activeNode!=null)
		{
			if(receiverKey.equals(activeNode.getItem().getKey()))
				return;
			activeNode.getItem().onTransmit(data, receiverKey);
			activeNode.getItem().getView().setVisible(false);
		}
		TreeNode<ContentController> transmitter = activeNode;
		TreeNode<ContentController> receiver = getNode(receiverKey);

		activeNode = receiver;
		prepareRoadMapView(receiver);
		getView().setContentView(activeNode.getItem().getView());
		activeNode.getItem().getView().setVisible(true);

		Object transmitterKey = null;
		if(transmitter!=null)
			transmitterKey = transmitter.getItem().getKey();
		System.out.println("MasterPresenter.transmit_1");
		receiver.getItem().onReceive(data,transmitterKey);
		System.out.println("MasterPresenter.transmit_2");
	}

	void fillPresenters(TreeNode<ContentController> node, List<BaseController> presenters)
	{
		presenters.add(node.getItem());
		for(TreeNode<ContentController> cNode: node.getChildNodes())
		{
			fillPresenters(cNode,presenters);
		}
	}
/*
	@Override
	protected List<ViewPresenter> getChildPresenters()
	{
		List<AbstractPresenter> result = new ArrayList<>();
		fillPresenters(this.getMap(),result);
		return result;
	}*/
}
