package com.jad.model;

import com.jad.common.ICar;
import com.jad.common.IMechanicalSetting;

public class NeonDecorator extends CarDecorator {
    private final String neonLayer;
    private IMechanicalSetting setting;

    public NeonDecorator(ICar inner, String neonLayer, IMechanicalSetting setting) {
        super(inner);
        this.neonLayer = neonLayer;
        this.setting = setting;
    }




@Override
public String getDisplay() {
    return mergeLayers(inner.getDisplay(), neonLayer);
}

@Override
public String getDescription() {
    return inner.getDescription()
            + "\nNeons : " + setting.getDescription();
}

@Override
public String getNames() {
    return inner.getNames() + "\nNéons Disco";
}

public static String mergeLayers(String base, String layer) {
    String[] baseLines = base.split("\\r?\\n");
    String[] layerLines = layer.split("\\r?\\n");
    int maxLines = Math.max(baseLines.length, layerLines.length);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLines; i++) {
        String b = i < baseLines.length ? baseLines[i] : "";
        String l = i < layerLines.length ? layerLines[i] : "";
        int maxCols = Math.max(b.length(), l.length());
        StringBuilder line = new StringBuilder();

        for (int c = 0; c < maxCols; c++) {
            char cb = c < b.length() ? b.charAt(c) : ' ';
            char cl = c < l.length() ? l.charAt(c) : ' ';
            // si le layer est espace, on garde la base, sinon on prend le layer
            line.append(cl == ' ' ? cb : cl);
        }

        sb.append(line);
        if (i < maxLines - 1) {
            sb.append("\n");
        }
    }
    return sb.toString();
}



}

