package juke.view;

import juke.events.EventEmitter;

public interface RadioButtonView extends View
{
    EventEmitter getCheckedChangedEmitter();
    String getText();
    void setText(String value);

    String getButtonsGroupName();
    void setButtonsGroup(String groupName);

    boolean isChecked();
    void setChecked(boolean pressed);
}
