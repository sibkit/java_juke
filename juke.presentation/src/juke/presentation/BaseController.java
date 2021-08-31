/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.presentation;

import juke.common.ChargingList;
import juke.exceptions.JukeException;
import juke.view.View;

import java.util.List;

/**
 *
 * @author chelovek
 */
public abstract class BaseController<T extends View> implements ViewController<T>
{
    private List<ViewController> childPresenters;
    private Controller parentController;
    private T view;


    public BaseController()
    {
        childPresenters = new ChargingList<ViewController>() {
            @Override
            protected void charge(ViewController element)
            {
                BaseController vp = (BaseController)element;
                if(vp.getParentController()!=null)
                    throw new JukeException("AbstractPresenter: charge");
                vp.setParentPresenter(BaseController.this);
            }

            @Override
            protected void discharge(ViewController element)
            {
                BaseController vp = (BaseController)element;
                if(vp.getParentController()==null)
                    throw new JukeException("AbstractPresenter: discharge");
                vp.setParentPresenter(null);
            }
        };
    }

    protected void setParentPresenter(ViewController parentPresenter)
    {
        this.parentController = parentPresenter;
    }

    @Override
    public List<ViewController> getChildControllers()
    {
        return childPresenters;
    }

    @Override
    public Controller getParentController()
    {
        return parentController;
    }

    @Override
    public ViewFormController getFormController()
    {
        if(this.parentController !=null)
        {
            if(parentController instanceof ViewController)
            {
                ViewController vp = (ViewController) parentController;
                return vp.getFormController();
            }
            else if (parentController instanceof ViewFormController)
            {
                return (ViewFormController) parentController;
            }
            else
                throw new JukeException("AbstractPresenter: getFormPresenter");

        }
        else
            return null;
    }

    @Override
    public void setView(T view)
    {
        this.view = view;
    }

    @Override
    public T getView()
    {
        return this.view;
    }
}
