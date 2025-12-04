package com.jad;

import com.jad.common.IController;
import com.jad.common.IModel;
import com.jad.common.IView;
import com.jad.controller.Controller;
import com.jad.model.Model;
import com.jad.view.View;

public class Main {

    public static void main(String[] args) {
        IController controller = new Controller();
        IView view = new View();
        IModel model = new Model();

        controller.setView(view);
        controller.setModel(model);
        controller.proceed();
    }
}
