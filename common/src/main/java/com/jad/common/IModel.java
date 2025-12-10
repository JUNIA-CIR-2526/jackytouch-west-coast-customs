package com.jad.common;

public interface IModel {
    String getCarData();            // lit car_base.txt
    void setCarData(String car);    // permet au Main d’injecter la voiture décorée
    String applyTuning(String base, String tuning); // "décorateur"
    String getTuningOption(int option);             // lit les fichiers de tuning
    void setDrivingStrategy(int strategy);
    String executeDrive();
}

