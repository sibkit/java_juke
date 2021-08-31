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
public interface EventEmitter<T extends EventObject>
{
    void addHandler(EventHandler<T> eventHandler);
    void removeHandler(EventHandler<T> eventHandler);
    void clearHandlers();

    EventHandler<T> getHandler(int index);
    int getHandlersCount();
}
