package juke.view;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chelovek
 * Date: 04.10.12
 * Time: 4:38
 * To change this template use File | Settings | File Templates.
 */
public interface ContainerView extends View
{
	List<View> getViews();

	//void addView(View view);
	//void removeView(View view);
	//void clear();
	//View createView(Class<? extends View> viewClass);
}
