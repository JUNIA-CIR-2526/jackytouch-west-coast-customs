package com.jad.common;

public interface IController {
    void setView(IView view);

    void proceed();

    void setModel(IModel model);
}
