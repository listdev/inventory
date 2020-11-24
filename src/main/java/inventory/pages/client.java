package inventory.pages;

import inventory.Main;
import inventory.models.DB;
import inventory.models.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class client {
    private JPanel panel;
    private JTextField name;
    private JTextField surname;
    private JButton button1;

    public client() {
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JTextField[] fields = {name, surname};
                if(Validator.validateTextFields(fields)) {
                    try{
                        String query = " insert into clients (first_name, last_name)" + " values (?, ?)";

                        // create the mysql insert prepared statement
                        PreparedStatement preparedStmt = DB.con.prepareStatement(query);
                        System.out.println(preparedStmt.toString());
                        preparedStmt.setString (1, name.getText());
                        preparedStmt.setString (2, surname.getText());

                        // execute the prepared statement
                        preparedStmt.execute();
                    } catch(Exception ex){ ex.printStackTrace(); }

                    JOptionPane.showMessageDialog( Main.gui, "Клиентският профил е създаден успешно.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public JPanel get_panel() {
        return panel;
    }
}
