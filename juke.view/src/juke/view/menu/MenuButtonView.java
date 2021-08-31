package juke.view.menu;

import juke.events.EventEmitter;

public interface MenuButtonView extends MenuItemView
{
    EventEmitter getClickEmitter();
}
