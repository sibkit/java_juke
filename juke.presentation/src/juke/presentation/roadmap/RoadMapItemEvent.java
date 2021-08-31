package juke.presentation.roadmap;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 10.10.12
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class RoadMapItemEvent extends EventObject
{

	private Object data;

	public RoadMapItemEvent(Object source, Object data)
	{
		super(source);
		this.data = data;
	}

	public Object getData()
	{
		return data;
	}
}
