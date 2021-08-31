package juke.swing.connectors;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.view.ButtonView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class JButtonConnector extends Connector<JButton> implements ButtonView
{
    private BaseEventEmitter<EventObject> notifyEmitter = new BaseEventEmitter<>();

    public JButtonConnector(JButton button)
    {
        super(button);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                notifyEmitter.emit(new EventObject(this));
            }
        });
    }

    @Override
    public EventEmitter getClickEmitter()
    {
        return notifyEmitter;
    }

    @Override
    public String getText()
    {
        return getComponent().getText();
    }

    @Override
    public void setText(String value)
    {
        getComponent().setText(value);
    }
}
