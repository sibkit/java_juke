/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juke.presentation;

import juke.view.ViewForm;

/**
 *
 * @author chelovek
 */
public abstract class BaseFormController<T extends ViewForm> implements ViewFormController<T>
{
    private T viewForm;
    //private ViewController contentPresenter;

    public BaseFormController(T viewForm)
    {
        this.viewForm = viewForm;
    }


    @Override
    public T getForm()
    {
        return this.viewForm;
    }

    //protected abstract ViewController createContentPresenter();

    /*
    @Override
    public ViewController getContentPresenter()
    {
        if(contentPresenter==null)
        {
            contentPresenter = createContentPresenter();
        }
        return contentPresenter;
    }*/
}
