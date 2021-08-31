/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.events;

import java.util.EventObject;

/**
 *
 * @author chelovek
 */
public class ValueEventObject<T> extends EventObject
{
    public ValueEventObject(Object source)
    {
        super(source);
    }
    
    public ValueEventObject(Object source, T value)
    {
        super(source);
        this.value = value;
    }
    
    private T value;

    /**
     * @return the value
     */
    public T getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value)
    {
        this.value = value;
    }
}
