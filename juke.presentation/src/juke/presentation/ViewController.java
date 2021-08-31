package juke.presentation;

import juke.view.View;

import java.util.List;

public interface ViewController<T extends View> extends Controller
{
    List<ViewController> getChildControllers();
    Controller getParentController();

    ViewFormController getFormController();

    void setView(T view);
    T getView();
}
