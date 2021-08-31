package juke.swing.connectors;

import juke.swing.common.ViewsList;
import juke.view.ContainerView;
import juke.view.View;

import javax.swing.*;
import java.util.*;

public class JPanelConnector extends Connector<JPanel> implements ContainerView
{

    private List<View> views;

    public JPanelConnector(JPanel panel)
    {
        super(panel);
        views = new ViewsList<>(panel);
    }

    @Override
    public List<View> getViews()
    {
        return views;
    }
}
