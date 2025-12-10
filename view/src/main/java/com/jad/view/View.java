package com.jad.view;

import com.jad.common.ICar;
import com.jad.common.IView;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;


public class View implements IView {

    public static final int SCREEN_WIDTH = 80;
    public static final int WAITING_TIME = 150;

    private final TextWindow window;

    public View(TextWindow window, TextWindowSettings setting) {
        this.window = window;
    }

    public void display(String text) {
        window.display(text);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void displayCar(final ICar car){
        this.display(car.getDisplay()
                + "\n\n"
                + View.addSeparatorBeforeCR(car.getDescription()," > ")
                + "\n\n"
                + View.addSeparatorBeforeCR(car.getNames(), " | ")
        );

    }

    public static String addSeparatorBeforeCR(String text, String sep) {
        String[] lines = text.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append(sep).append(lines[i]);
        }
        return sb.toString();
    }

    @Override
    public boolean isOff(String action) {
        return this.window.isOff(action);
    }
}
