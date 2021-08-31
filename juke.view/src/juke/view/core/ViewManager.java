/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.view.core;

import juke.view.View;
import juke.view.ViewForm;

/**
 *
 * @author chelovek
 */
public interface ViewManager
{
	void invoke(Runnable runnable);
	<T extends ViewForm> T createViewForm(Class<T> formClass);
	<T extends View> T createView(Class<T> viewClass);
}
