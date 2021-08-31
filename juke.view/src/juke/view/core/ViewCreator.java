package juke.view.core;

import juke.view.View;

public interface ViewCreator<T extends View>
{
    Class<T> getViewClass();
    T createView();
}
