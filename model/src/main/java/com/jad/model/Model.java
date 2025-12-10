package com.jad.model;

import com.jad.common.IModel;
import java.io.InputStream;
import java.util.Scanner;

public class Model implements IModel {
    private String currentCar;
    private int currentStrategy = 0;

    public Model() {
        this.currentCar = lireFichier("car_base.txt");
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

    @Override
    public void setDrivingStrategy(int strategy) {
        this.currentStrategy = strategy;
    }

    @Override
    public String executeDrive() {
        switch (currentStrategy) {
            case 1: return "Mode Normal: conduite équilibrée";
            case 2: return "Mode Sport: accélération maximale";
            case 3: return "Mode Éco: consommation minimale";
            default: return "Aucun mode sélectionné";
        }
    }



    private String lireFichier(String nom) {
        InputStream is = getClass().getResourceAsStream("/" + nom);
        Scanner scanner = new Scanner(is, "UTF-8");
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return sb.toString();
    }
}
