package inventory.pages;

import inventory.Main;
import inventory.models.DB;
import inventory.models.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class product {
    private JPanel panel;
    private JTextField inventory_number;
    private JTextArea description;
    private JComboBox type;
    private JSlider depreciation;
    private JTextField producted_at;
    private JButton създаванеButton;
    private JLabel typeLabel;

    public product() {
        създаванеButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField[] fields = {inventory_number, producted_at};
                if(Validator.validateTextFields(fields)) {
                    int depreciationValue = (type.getSelectedItem() == "ДМА") ? depreciation.getValue() : null;
                    System.out.println(depreciationValue);
                    if(!(producted_at.getText()).matches("^\\d{4}$\n")) {
                        JOptionPane.showMessageDialog(Main.gui, "Невалидна година на производство.", "Грешка!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try{

                        String query = " insert into products (inventory_number, description, type, depreciation, produced_at)" + " values (?, ?, ?, ?, ?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = DB.con.prepareStatement(query);
                        System.out.println(preparedStmt.toString());
                        preparedStmt.setString (1, inventory_number.getText());
                        preparedStmt.setString (2, description.getText());
                        preparedStmt.setString (3, type.getSelectedItem().toString());
                        preparedStmt.setString (4, String.valueOf(depreciationValue));
                        preparedStmt.setString (5, producted_at.getText());

                        // execute the preparedstatement
                        preparedStmt.execute();
                    } catch(Exception ex){ ex.printStackTrace(); }

                    JOptionPane.showMessageDialog( Main.gui, "Продуктът е създаден успешно.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        type.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type.getSelectedItem() == "ДМА") {
                    depreciation.setVisible(true);
                    typeLabel.setVisible(true);
                }
                else {
                    depreciation.setVisible(false);
                    typeLabel.setVisible(false);
                }
            }
        });
    }

    public JPanel get_panel() {
        return panel;
    }

}
