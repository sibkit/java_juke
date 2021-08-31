package juke.view.listView;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 04.10.12
 * Time: 4:30
 * To change this template use File | Settings | File Templates.
 */
public class ListViewItem
{
	public ListViewItem(){}

	public ListViewItem(String text, Object userData)
	{
		this.setText(text);
		this.setUserData(userData);
	}

	private String text;
	private Object userData;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Object getUserData()
	{
		return userData;
	}

	public void setUserData(Object userData)
	{
		this.userData = userData;
	}

	@Override
	public String toString()
	{
		return text;
	}
}
