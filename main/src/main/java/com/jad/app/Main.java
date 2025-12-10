package com.jad.app;

import com.jad.common.ICar;
import com.jad.controller.Controller;
import com.jad.model.BasicCar;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;
import com.jad.view.View;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");
        String baseDisplay = ".... ASCII de la voiture ....";
        String baseDescription = "Voiture de base";
        String baseName = "Base";
        ICar baseCar = new BasicCar(baseDisplay, baseDescription, baseName);

        TextWindowSettings settings = new TextWindowSettings();
        settings.setTitle("JackyTouch");

        TextWindow window = new TextWindow(settings);
        window.setVisible(true);
        View view = new View(window, settings);
        Controller controller = new Controller(view, baseCar);

        controller.start();
        System.out.println("End");
    }
}
