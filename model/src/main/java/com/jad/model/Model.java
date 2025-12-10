package com.jad.model;

import com.jad.common.ICar;
import com.jad.common.IModel;
import com.jad.common.IView;

import com.jad.model.NeonDecorator;
import com.jad.model.SpoilerDecorator;
import com.jad.model.SportSetting;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Model implements IModel {
    private String currentCar;
    private int currentStrategy = 0;

    String baseDisplay = ".... ASCII de la voiture ....";
    String baseDescription = "Voiture de base";
    String baseName = "Base";

    ICar baseCar = new BasicCar(baseDisplay, baseDescription, baseName);
    private IView view;

    public Model() {
        this.currentCar = lireFichier("car_base.txt");
    }

    public Model(IView view) {
        this.view = view;
        this.currentCar = lireFichier("car_base.txt");
    }

    public void addDecorator(ICar car) {

        view.displayCar(car);

        car = new NeonDecorator(
                car,
                lireFichier("neon.txt"),
                new SportSetting()
        );
        view.displayCar(car);

        car = new SpoilerDecorator(
                car,
                lireFichier("spoiler.txt"),
                new SportSetting()
        );
        view.displayCar(car);
    }


    @Override
    public ICar getBaseCar() {
        return this.baseCar;
    }

    @Override
    public String getCarData() {
        return currentCar;
    }

    @Override
    public void setCarData(String car) {
        this.currentCar = car;
    }

    @Override
    public String getTuningOption(int option) {
        switch(option) {
            case 1: return lireFichier("exhaust.txt");
            case 2: return lireFichier("neon.txt");
            case 3: return lireFichier("rims.txt");
            case 4: return lireFichier("spoiler.txt");
            default: return "";
        }
    }

    @Override
    public String applyTuning(String base, String tuning) {
        String[] baseLines = base.split("\n");
        String[] tuningLines = tuning.split("\n");
        StringBuilder result = new StringBuilder();

        int maxLines = Math.max(baseLines.length, tuningLines.length);

        for (int i = 0; i < maxLines; i++) {
            String baseLine = i < baseLines.length ? baseLines[i] : "";
            String tuningLine = i < tuningLines.length ? tuningLines[i] : "";
            result.append(mergeLine(baseLine, tuningLine)).append("\n");
        }
        return result.toString();
    }

    private String mergeLine(String base, String tuning) {
        if (tuning.isEmpty()) return base;

        char[] result = base.toCharArray();
        char[] overlay = tuning.toCharArray();

        for (int i = 0; i < Math.min(result.length, overlay.length); i++) {
            if (overlay[i] != '.' && overlay[i] != ' ') {
                result[i] = overlay[i];
            }
        }

        if (overlay.length > result.length) {
            return new String(result) + tuning.substring(result.length);
        }
        return new String(result);
    }


    private String lireFichier(String nom) {
        InputStream inputStream = Model.class.getResourceAsStream("/" + nom);
        if (inputStream == null) {

            throw new RuntimeException("Fichier " + nom + " n'existe pas");
        }
        try {
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
