import com.jad.common.IModel;
import com.jad.common.IView;
import com.jad.controller.Controller;
import com.jad.model.BasicCar;
import com.jad.model.Model;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;
import com.jad.view.View;

import java.awt.event.KeyEvent;

public static void main(String[] args) {
    System.out.println("Start");

    TextWindowSettings settings = new TextWindowSettings();
    settings.addKeyboardListener(KeyEvent.VK_SPACE, "Proceed");
    settings.setListenKeyboard(true);
    TextWindow window = new TextWindow(settings);
    window.setVisible(true);
    window.requestFocus();
    window.toFront();

    settings.setTitle("JackyTouch");
    settings.setScreenWidth(View.SCREEN_WIDTH);






    System.out.println("Avant touche : " + window.isOff("Proceed"));
                      // tu as 5s pour appuyer sur espace
    System.out.println("Après touche : " + window.isOff("Proceed"));





    IView view = new View(window, settings);
    IModel model = new Model(view);

    Controller controller = new Controller(view, model);
    controller.start();

    System.out.println("End");
}

