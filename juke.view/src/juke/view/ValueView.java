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
public interface ValueView<T> extends View 
{
    EventEmitter getValueChangedEmitter();
    T getValue();
    void setValue(T value);
    void setError(String errorMessage);
}
