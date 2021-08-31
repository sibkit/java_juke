package juke.view.roadmap;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 27.09.12
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class RoadMapItem
{
	private BaseEventEmitter notifyEmitter = new BaseEventEmitter();
	private BaseEventEmitter textChangedEmitter = new BaseEventEmitter();

	private String text;

	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
		textChangedEmitter.emit(new EventObject(this));
	}

	public EventEmitter getNotifyEmitter()
	{
		return notifyEmitter;
	}
	public EventEmitter getTextChangedEmitter()
	{
		return textChangedEmitter;
	}
}
