package juke.swing.connectors;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.view.ValueView;

import javax.swing.*;
import java.util.EventObject;

public class JLabelConnector extends Connector implements ValueView<String>
{

    private BaseEventEmitter<EventObject> valueChangedEmitter = new BaseEventEmitter<>();

    public JLabelConnector(JLabel label)
    {
        super(label);
    }

    JLabel getLabel()
    {
        return (JLabel)getUIObject();
    }



    @Override
    public EventEmitter getValueChangedEmitter()
    {
        return valueChangedEmitter;
    }

    @Override
    public String getValue()
    {
        return getLabel().getText();
    }

    @Override
    public void setValue(String value)
    {
        getLabel().setText(value);
        valueChangedEmitter.emit(new EventObject(this));
    }

    @Override
    public void setError(String errorMessage)
    {
        System.out.println("ERROR: "+errorMessage);
    }
}
