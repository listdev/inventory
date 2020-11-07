package inventory;

import inventory.GUI.Menu;
import inventory.models.DB;
import inventory.pages.mol;

import javax.swing.*;

public class Main {
    public static JFrame gui;
    public static void main(String[] args) {
        new DB();
        gui = new JFrame();
        new Menu(gui);
        new mol();

        gui.pack();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setTitle("Създай МОЛ");

    }
}
