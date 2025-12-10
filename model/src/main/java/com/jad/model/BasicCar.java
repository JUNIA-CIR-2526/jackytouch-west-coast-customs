package com.jad.model;

import com.jad.common.ICar;

public class BasicCar implements ICar {
    private final String display;
    private final String description;
    private final String name;

    public BasicCar(String display, String description, String name) {
        this.display = display;
        this.description = description;
        this.name = name;
    }

    @Override
    public String getDisplay() {
        return display;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getNames() {
        return name;
    }
}

