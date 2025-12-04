package com.jad.view;

import com.jad.common.IView;
import com.jad.textwindow.TextWindow;

public class View implements IView {

    private final TextWindow textWindow;

    public View() {
        this.textWindow = new TextWindow();
        this.textWindow.setVisible(true);
    }


    @Override
    public void display(String message) {
        textWindow.display(message);
    }
}
