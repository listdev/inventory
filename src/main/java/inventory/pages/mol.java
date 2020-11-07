package inventory.pages;

import inventory.Main;
import inventory.models.DB;
import inventory.models.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class mol{
    private JPanel panel;
    private JTextField name;
    private JTextField surname;
    private JButton button1;

    public mol() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] fields = {name, surname};
                if(Validator.validateTextFields(fields)) {
                    try{
                        String query = " insert into users_mol (first_name, last_name)" + " values (?, ?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = DB.con.prepareStatement(query);
                        System.out.println(preparedStmt.toString());
                        preparedStmt.setString (1, name.getText());
                        preparedStmt.setString (2, surname.getText());

                        // execute the preparedstatement
                        preparedStmt.execute();

                        DB.con.close();
                    } catch(Exception ex){ ex.printStackTrace(); }

                    JOptionPane.showMessageDialog( Main.gui, "МОЛ потребителят е създаден успешно.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public JPanel get_panel() {
        return panel;
    }
}
