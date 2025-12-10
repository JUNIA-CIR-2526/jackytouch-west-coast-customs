package com.jad.model;

import com.jad.common.ICar;
import com.jad.common.IMechanicalSetting;

public class SpoilerDecorator extends CarDecorator {
    private final String spoilerLayer;
    private IMechanicalSetting setting;

    public SpoilerDecorator(ICar inner, String spoilerLayer, IMechanicalSetting setting) {
        super(inner);
        this.spoilerLayer = spoilerLayer;
        this.setting = setting;
    }

    @Override
    public String getDisplay() {
        return AsciiUtils.mergeLayers(inner.getDisplay(), spoilerLayer);
    }

    @Override
    public String getDescription() {
        return inner.getDescription()
                + "\nSpoiler : " + setting.getDescription();
    }

    @Override
    public String getNames() {
        return inner.getNames()
                + "\nSpoiler " + setting.getName();
    }
}
