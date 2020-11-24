package inventory.pages;

import inventory.models.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class products {
    private JTable showTable;
    private JPanel panel;
    private JComboBox typeCombo;
    private JComboBox clientCombo;
    private JTextField textField1;
    private JComboBox defectiveCombo;

    private JComboBox availableCombo;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;

    public products() {
        createTable();
        createTypeCombo();
        createClientCombo();
        createDefectiveCombo();
        createAvailableCombo();
    }

    private void createTable() {
        ArrayList<Object> rows = new ArrayList<Object>();
        try {
            String query = "SELECT * FROM products";
            Statement st = DB.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                rows.add(new String[]{
                        rs.getString("id"),
                        rs.getString("inventory_number"),
                        rs.getString("type"),
                        (rs.getBoolean("defective")) ? "Да" : "Не",
                        rs.getString("produced_at"),
                });
            }

            Object[][] data = { rows.toArray() };
            showTable.setModel(new DefaultTableModel(
                    data,
                    new String[]{"#", "Инвентарен №", "Тип", "Бракуван", "Година (на произв.)"}
            ));
        } catch(Exception ex){ ex.printStackTrace(); }


        TableColumnModel columns = showTable.getColumnModel();
        columns.getColumn(1).setMinWidth(200);
        columns.getColumn(4).setMinWidth(150);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
    }

    private void createTypeCombo() {
        typeCombo.setModel(new DefaultComboBoxModel(new String[]{"Всички", "ДМА", "МА"}));
    }

    private void createClientCombo() {
        ArrayList<String> clients = new ArrayList<String>();
        try {
            String query = "SELECT * FROM clients";
            Statement st = DB.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            clients.add("Всички");
            while (rs.next()) {
                clients.add(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
            clientCombo.setModel(new DefaultComboBoxModel(clients.toArray()));
        } catch(Exception ex){ ex.printStackTrace(); }
    }

    private void createDefectiveCombo() {
        defectiveCombo.setModel(new DefaultComboBoxModel(new String[]{"Всички", "Налични", "Бракувани"}));
    }

    private void createAvailableCombo() {
        availableCombo.setModel(new DefaultComboBoxModel(new String[]{"Всички", "Налични", "Изчерпани"}));
    }

    public JPanel get_panel() {
        return panel;
    }
}
