package com.jad.model;

public final class AsciiUtils {
    private AsciiUtils() {}

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
