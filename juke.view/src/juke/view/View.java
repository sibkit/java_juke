/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.view;

/**
 *
 * @author chelovek
 */
public interface View
{
    Boolean isVisible();
    void setVisible(Boolean value);
    Boolean isEnabled();
    void setEnabled(Boolean value);
	Object getUIObject();
}
