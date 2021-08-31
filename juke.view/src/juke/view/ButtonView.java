/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.view;


import juke.events.EventEmitter;

/**
 *
 * @author chelovek
 */
public interface ButtonView extends View
{
    EventEmitter getClickEmitter();
    String getText();
    void setText(String value);
}
