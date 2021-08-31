/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.events;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author chelovek
 */
public final class BaseEventEmitter<T extends EventObject> implements EventEmitter<T>
{
    private List<EventHandler<T>> eventHandlers = new ArrayList<>();

    public void emit(T eventObject)
    {
        for(EventHandler handler : eventHandlers)
            handler.handle(eventObject);
    }

    @Override
    public void addHandler(EventHandler<T> eventHandler)
    {
        eventHandlers.add(eventHandler);
    }

    @Override
    public void removeHandler(EventHandler<T> eventHandler)
    {
        eventHandlers.remove(eventHandler);
    }

    @Override
    public void clearHandlers()
    {
        eventHandlers.clear();
    }

    @Override
    public EventHandler<T> getHandler(int index)
    {
        return eventHandlers.get(index);
    }

    @Override
    public int getHandlersCount()
    {
        return eventHandlers.size();
    }
}
