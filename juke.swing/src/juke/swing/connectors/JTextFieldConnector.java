package juke.swing.connectors;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.view.ValueView;

import javax.swing.*;
import java.util.EventObject;

public class JTextFieldConnector extends Connector implements ValueView<String>
{
    private BaseEventEmitter<EventObject> valueChangedEmitter = new BaseEventEmitter<>();

    public JTextFieldConnector(JTextField textField)
    {
        super(textField);
    }

    JTextField getTextField()
    {
        return (JTextField)getUIObject();
    }

    @Override
    public EventEmitter getValueChangedEmitter()
    {
        return valueChangedEmitter;
    }

    @Override
    public String getValue()
    {
        return getTextField().getText();
    }

    @Override
    public void setValue(String value)
    {
        getTextField().setText(value);
    }

    @Override
    public void setError(String errorMessage)
    {
        System.out.println("ERROR: "+errorMessage);
    }
}
