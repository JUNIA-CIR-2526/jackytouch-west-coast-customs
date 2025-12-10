package com.jad.controller;

import com.jad.common.ICar;
import com.jad.view.View;
import com.jad.model.NeonDecorator;
import com.jad.model.SpoilerDecorator;
import com.jad.model.SportSetting;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {

    private final View view;
    private ICar currentCar;

    public Controller(View view, ICar baseCar) {
        this.view = view;
        this.currentCar = baseCar; // instance unique
    }

    public void start() {
        view.displayCar(currentCar);

        currentCar = new NeonDecorator(
                currentCar,
                loadLayer("neon.txt"),
                new SportSetting()
        );
        view.displayCar(currentCar);

        currentCar = new SpoilerDecorator(
                currentCar,
                loadLayer("spoiler.txt"),
                new SportSetting()
        );
        view.displayCar(currentCar);
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
