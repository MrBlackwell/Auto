import javax.swing.*;
import java.awt.*;


public class Order extends JFrame {
    public void createAndShowGUI() {
        JTextField name = new JTextField("Название запчасти");
        JTextField VIN_number = new JTextField("VIN запчасти");
        JTextField amount = new JTextField("1");
        JButton order = new JButton("Заказать");
        JLabel forname = new JLabel("Название:");
        JLabel forVIN = new JLabel("VIN номер:");
        JLabel foramount = new JLabel("Количество:");
        order.addActionListener(new orderAction(name, VIN_number, amount));

        setLayout(null);

        add(name);
        add(VIN_number);
        add(amount);
        add(order);
        add(forname);
        add(forVIN);
        add(foramount);

        Insets insets = getInsets();
        Dimension size = name.getPreferredSize();
        name.setBounds(25 + insets.left, 50 + insets.top, size.width, size.height);
        size = VIN_number.getPreferredSize();
        VIN_number.setBounds(25 + insets.left, 100 + insets.top, size.width, size.height);
        size = amount.getPreferredSize();
        amount.setBounds(25 + insets.left, 150 + insets.top, size.width, size.height);
        size = order.getPreferredSize();
        order.setBounds(25 + insets.left, 175 + insets.top, size.width, size.height);
        size = forname.getPreferredSize();
        forname.setBounds(25 + insets.left, 25 + insets.top, size.width, size.height);
        size = forVIN.getPreferredSize();
        forVIN.setBounds(25 + insets.left, 75 + insets.top, size.width, size.height);
        size = foramount.getPreferredSize();
        foramount.setBounds(25 + insets.left, 125 + insets.top, size.width, size.height);

        setPreferredSize(new Dimension(250, 250));
        pack();
        setVisible(true);
    }
}
