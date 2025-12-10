package com.jad.app;

import com.jad.common.ICar;
import com.jad.common.IModel;
import com.jad.common.IView;
import com.jad.controller.Controller;
import com.jad.model.BasicCar;
import com.jad.model.Model;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;
import com.jad.view.View;

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");



        TextWindowSettings settings = new TextWindowSettings();
        settings.setTitle("JackyTouch");

        TextWindow window = new TextWindow(settings);
        window.setVisible(true);
        window.requestFocus();
        window.toFront();

        IModel model = new Model();
        IView view = new View(window, settings);
        Controller controller = new Controller(view,model);

        controller.start();
        System.out.println("End");
    }
}
