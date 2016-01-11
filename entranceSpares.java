import javax.swing.*;
import java.awt.*;


public class entranceSpares extends JFrame {
    public void createAndShowGUI() {
        JLabel Name = new JLabel("Название:");
        JLabel vin = new JLabel("VIN номер:");
        JLabel Price = new JLabel("Цена:");
        JLabel Amount = new JLabel("Количество:");
        JTextField name = new JTextField();
        JTextField VIN = new JTextField();
        JTextField price = new JTextField();
        JTextField amount = new JTextField();

        JButton addd = new JButton("Добавить");
        addd.addActionListener(new addSpareAction(name, price, VIN, amount));

        setLayout(null);

        add(Name);
        add(vin);
        add(Price);
        add(Amount);
        add(name);
        add(VIN);
        add(price);
        add(amount);
        add(addd);

        Insets insets = getInsets();
        Dimension size = Name.getPreferredSize();
        Name.setBounds(25 + insets.left, 25 + insets.top, size.width, size.height);
        size = name.getPreferredSize();
        name.setBounds(25 + insets.left, 50 + insets.top, 100, size.height);
        size = vin.getPreferredSize();
        vin.setBounds(25 + insets.left, 75 + insets.top, size.width, size.height);
        size = VIN.getPreferredSize();
        VIN.setBounds(25 + insets.left, 100 + insets.top, 100, size.height);
        size = Price.getPreferredSize();
        Price.setBounds(25 + insets.left, 125 + insets.top, size.width, size.height);
        size = price.getPreferredSize();
        price.setBounds(25 + insets.left, 150 + insets.top, 100, size.height);
        size = Amount.getPreferredSize();
        Amount.setBounds(25 + insets.left, 175 + insets.top, size.width,size.height);
        size = amount.getPreferredSize();
        amount.setBounds(25 + insets.left, 200 + insets.top, 100, size.height);
        size = addd.getPreferredSize();
        addd.setBounds(25 + insets.left, 225 + insets.top, size.width, size.height);

        setPreferredSize(new Dimension(250, 320));
        pack();
        setVisible(true);
    }
}
