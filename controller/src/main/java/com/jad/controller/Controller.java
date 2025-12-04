package com.jad.controller;

import com.jad.common.IController;
import com.jad.common.IModel;
import com.jad.common.IView;

public class Controller implements IController {

    private IView view;
    private IModel model;

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void proceed() {
        String data = model.getCarData();
        view.display(data);
    }
}
