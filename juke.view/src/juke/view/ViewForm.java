/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.view;

import juke.events.EventEmitter;

import java.util.EventObject;

/**
 *
 * @author chelovek
 */
public interface ViewForm
{
    EventEmitter<EventObject> getClosedEmitter();
    String getCaption();
    void setCaption(String caption);
    void close();
    void hide();
    void show(ViewForm view);
    void showModal(ViewForm view);

}
