package juke.swing.core;

import juke.exceptions.JukeException;
import juke.view.View;
import juke.view.ViewForm;
import juke.view.core.ViewCreator;
import juke.view.core.ViewFormCreator;
import juke.view.core.ViewManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingViewManager implements ViewManager
{

    Map<Class, ViewCreator> contentViewCreatorsMap;
    Map<Class, ViewFormCreator> viewFormCreatorsMap;

    @Override
    public void invoke(Runnable runnable)
    {
        SwingUtilities.invokeLater(runnable);
    }

    @Override
    public <T extends ViewForm> T createViewForm(Class<T> formClass)
    {
        if(viewFormCreatorsMap ==null)
            throw new JukeException("SwingViewManager: createViewForm (ViewModules not installed)");

        ViewFormCreator formCreator = viewFormCreatorsMap.get(formClass);
        if(formCreator==null)
            throw new JukeException("SwingViewManager: createViewForm (Creator not found)");

        return (T)formCreator.createViewForm();
    }

    @Override
    public <T extends View> T createView(Class<T> viewClass)
    {
        ViewCreator creator = contentViewCreatorsMap.get(viewClass);
        if(creator==null)
            throw new JukeException("SwingViewManager: createView (Creator not found)");

        return (T)creator.createView();
    }


    public void setViewModules(List<SwingViewModule> modules)
    {
        contentViewCreatorsMap = new HashMap<>();
        viewFormCreatorsMap = new HashMap<>();
        for(SwingViewModule module: modules)
        {
            for(ViewCreator cvc : module.getViewCreators())
            {
                if(contentViewCreatorsMap.containsKey(cvc.getViewClass()))
                    throw new JukeException("SwingViewManager: setViewModules (contentCreator already exits)");

                contentViewCreatorsMap.put(cvc.getViewClass(),cvc);
            }

            for(ViewFormCreator vfc : module.getViewFormCreators())
            {
                if(viewFormCreatorsMap.containsKey(vfc.getViewFormClass()))
                    throw new JukeException("SwingViewManager: setViewModules (viewFormCreator already exits)");

                viewFormCreatorsMap.put(vfc.getViewFormClass(), vfc);
            }
        }
    }
}
