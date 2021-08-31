package juke.swing.core;

import juke.view.core.ViewCreator;
import juke.view.core.ViewFormCreator;

import java.util.List;

public interface SwingViewModule
{
    List<ViewCreator> getViewCreators();
    List<ViewFormCreator> getViewFormCreators();
}
