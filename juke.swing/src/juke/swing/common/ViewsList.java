package juke.swing.common;

import juke.common.ChargingList;
import juke.exceptions.JukeException;
import juke.swing.connectors.Connector;
import juke.view.View;

import java.awt.*;

public class ViewsList<T extends View> extends ChargingList<T>
{
    Container container;
    public ViewsList(Container container)
    {
        this.container = container;
    }

    @Override
    protected void charge(T element)
    {
        if(element instanceof Connector)
        {
            Connector cc = (Connector)element;
            container.add(cc.getComponent());
        }
        else
            throw new JukeException("ViewList: charge (View not supported)");
    }

    @Override
    protected void discharge(T element)
    {
        if(element instanceof Connector)
        {
            Connector cc = (Connector)element;
            container.remove(cc.getComponent());
        }
        else
            throw new JukeException("ViewList: charge (View not supported)");
    }
}
