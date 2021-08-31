package juke.presentation.roadmap;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.presentation.BaseController;
import juke.view.View;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 26.09.12
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class ContentController<T extends View> extends BaseController<T>
{
	private BaseEventEmitter captionChangedEmitter = new BaseEventEmitter();
	private String viewCaption;
	private MasterController masterController;

	public String getViewCaption()
	{
		return viewCaption;
	}

	public void setViewCaption(String caption)
	{
		viewCaption = caption;
		captionChangedEmitter.emit(new EventObject(this));
	}

	public abstract Object getKey();

	public abstract Veto onReceive(Object data, Object transmitterKey);

	public abstract Veto onTransmit(Object data, Object receiverKey);

	public ContentController(T view)
	{
		super.setView(view);
	}

	public ContentController()
{

}

	public EventEmitter getCaptionChangedEmitter()
	{
		return captionChangedEmitter;
	}
	public MasterController getMasterController()
	{
		return masterController;
	}
	public void setMasterController(MasterController masterController) {
		this.masterController = masterController;
	}
}
