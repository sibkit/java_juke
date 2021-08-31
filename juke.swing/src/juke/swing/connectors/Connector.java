package juke.swing.connectors;

import juke.view.View;

import javax.swing.*;

public class Connector<T extends JComponent> implements View
{
    private T component;

    public Connector(T component)
    {
        connect(component);
    }

    public Connector(){}

    @Override
    public Boolean isVisible()
    {
        return component.isVisible();
    }

    @Override
    public void setVisible(Boolean value)
    {
        component.setVisible(value);
    }

    @Override
    public Boolean isEnabled()
    {
        return component.isEnabled();
    }

    @Override
    public void setEnabled(Boolean value)
    {
        component.setEnabled(value);
    }

    @Override
    public Object getUIObject()
    {
        return component;
    }

    public T getComponent()
    {
        return component;
    }

    public void connect(T component)
    {
        this.component = component;
    }
}
