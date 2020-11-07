package inventory.GUI;

import inventory.Main;

import javax.swing.*;
import java.awt.*;

public class Content {
    public Content() {}

    public void set(JPanel panel, String title) {
        Container pane = Main.gui.getContentPane();
        pane.removeAll();

        pane.add(panel);
        Main.gui.pack();
        Main.gui.setTitle(title);
        Main.gui.revalidate();
    }
}
