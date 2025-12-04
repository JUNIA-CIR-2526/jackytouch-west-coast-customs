package com.jad.model;

import com.jad.common.IModel;
import java.io.InputStream;
import java.util.Scanner;

public class Model implements IModel {

    private String carData;

    public Model() {
        loadCarData();
    }

    private void loadCarData() {
        String car = lireFichier("car_base.txt");
        String exhaust = lireFichier("exhaust.txt");
        String neon = lireFichier("neon.txt");
        String rims = lireFichier("rims.txt");
        String spoiler = lireFichier("spoiler.txt");

        this.carData = car + exhaust + neon + rims + spoiler;
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

    @Override
    public String getCarData() {
        return carData;
    }
}
