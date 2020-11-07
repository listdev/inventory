package inventory.models;

import inventory.Main;

import javax.swing.*;

public class Validator {
    public static boolean validateTextFields(JTextField[] data) {
        JTextField[] returnData;
        for (int i = 0; i < data.length; i++) {
            if(data[i].getText().equals("")) {
                JOptionPane.showMessageDialog(Main.gui, "Моля, попълнете всички полета.", "Грешка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
