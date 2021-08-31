package juke.view.core;

import juke.view.ViewForm;

public interface ViewFormCreator<T extends ViewForm>
{
    T createViewForm();
    Class<T> getViewFormClass();
}
