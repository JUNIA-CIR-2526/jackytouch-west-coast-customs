package com.jad.model;

import com.jad.common.ICar;

public abstract class CarDecorator implements ICar {

    protected final ICar inner;

    protected CarDecorator(ICar inner) {
        this.inner = inner;
    }

    @Override
    public String getDisplay() {
        return inner.getDisplay();
    }

    @Override
    public String getDescription() {
        return inner.getDescription();
    }

    @Override
    public String getNames() {
        return inner.getNames();
    }


}

