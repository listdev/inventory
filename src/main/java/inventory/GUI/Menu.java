package inventory.GUI;

import inventory.pages.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Menu {
    JMenu menu_users,
            menu_products,
            menu_checks,
            menu_checks_products,
            menu_checks_products_status,
            menu_checks_products_category;

    public Menu(JFrame gui) {
        JMenuBar mb = new JMenuBar();

        menu_users = new JMenu("Потребители");
        menu_products = new JMenu("Продукти");
        menu_checks = new JMenu("Справки");
        menu_checks_products = new JMenu("Списък продукти");
        menu_checks_products_status = new JMenu("Статус");
        menu_checks_products_category = new JMenu("Категория");

        menu_users.add(new JMenuItem(new ActionHandler("Регистриране на МОЛ")));
        menu_users.add(new JMenuItem(new ActionHandler("Регистриране на клиент")));

        menu_products.add(new JMenuItem(new ActionHandler("Регистриране на продукт")));
        menu_products.add(new JMenuItem(new ActionHandler("Регистриране на продукт към клиент")));
        menu_products.add(new JMenuItem(new ActionHandler("Бракуване")));

        menu_checks.add(new JMenuItem("Списък клиенти"));

        menu_checks_products.add(new JMenuItem(new ActionHandler("Всички продукти")));
        menu_checks_products.add(new JMenuItem(new ActionHandler("Бракувани продукти")));

        menu_checks_products_status.add(new JMenuItem(new ActionHandler("Наличен")));
        menu_checks_products_status.add(new JMenuItem(new ActionHandler("Липсващ")));

        menu_checks_products_category.add(new JMenuItem(new ActionHandler("ДМА")));
        menu_checks_products_category.add(new JMenuItem(new ActionHandler("МА")));

        menu_checks_products.add(menu_checks_products_status);
        menu_checks_products.add(menu_checks_products_category);
        menu_checks.add(menu_checks_products);

        mb.add(menu_users);
        mb.add(menu_products);
        mb.add(menu_checks);

        gui.setJMenuBar(mb);
    }
}

class ActionHandler extends AbstractAction {
    public ActionHandler(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Content content = new Content();
        if(e.getActionCommand() == "Регистриране на клиент") {
            content.set(new client().get_panel(), e.getActionCommand());
        }
        else if(e.getActionCommand() == "Регистриране на продукт") {
            content.set(new product().get_panel(), e.getActionCommand());
        }
        else {
            content.set(new mol().get_panel(), e.getActionCommand());
        }
    }
}
