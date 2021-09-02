/*package juke.presentation.budzo.core.swing.core;

import juke.presentation.ViewFormController;
import juke.presentation.ViewController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PresentationManager
{
    private List<PresentationModule> modules;

    private Map<String, ControllerCreator> presenterCreators;
    private Map<String, FormControllerCreator> formPresenterCreators;

    public ViewFormController createFormPresenter(String formName)
    {
        FormControllerCreator creator = formPresenterCreators.get(formName);
        return creator.createFormPresenter();
    }

    private ViewController createPagePresenter(String pageName)
    {
        ControllerCreator creator = presenterCreators.get(pageName);
        return creator.createController();
    }

    public void setModules(List<PresentationModule> modules)
    {
        this.modules = modules;
        presenterCreators = new HashMap<>();
        formPresenterCreators = new HashMap<>();

        for(PresentationModule module: modules)
        {
            for(ControllerCreator pc : module.getPresenterCreators())
                presenterCreators.put(pc.getPageCode(),pc);

            for(FormControllerCreator fpc: module.getFormPresenterCreators())
                formPresenterCreators.put(fpc.getFormCode(),fpc);
        }
    }
}
*/