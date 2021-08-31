package juke.presentation;

import juke.view.ViewForm;

public interface ViewFormController<T extends ViewForm> extends Controller
{
    //void setForm(T form);
    T getForm();
    //ViewController getContentPresenter();
}
