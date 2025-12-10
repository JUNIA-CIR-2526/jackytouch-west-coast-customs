package com.jad.controller;

import com.jad.common.ICar;
import com.jad.common.IModel;

import com.jad.common.IView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {

    private final IView view;
    private final IModel model;
    private ICar currentCar;

    public Controller(IView view,IModel model) {
        this.view = view;
        this.model = model;
        this.currentCar = model.getBaseCar();
    }

    public void start() {
        this.currentCar = model.getBaseCar();
        model.addDecorator(currentCar);
    }

    public static String loadLayer(String resourceName) {
        try (InputStream is = Controller.class.getResourceAsStream("/" + resourceName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Impossible de charger " + resourceName, e);
        }
    }
}
