package com.jad.model;

import com.jad.common.IMechanicalSetting;

public class SportSetting implements IMechanicalSetting {
    @Override
    public String getName() { return "Sport"; }

    @Override
    public String getDescription() {
        return "Suspension dure, accélération max";
    }


}



