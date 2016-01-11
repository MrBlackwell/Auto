import javax.swing.*;
import java.awt.*;


public class sparesSearch extends JPanel {
    public JPanel createAndShowGUI() {
        JLabel VIN = new JLabel("Введите VIN номер");
        JTextField vin = new JTextField("VIN");
        JButton search = new JButton("Поиск");
        search.addActionListener(new searchSpareAction(vin));
        JLabel enterId = new JLabel("Введите id продаваемой запчасти");
        JTextField spareId = new JTextField();
        JButton sell = new JButton("Продать");
        JLabel selll = new JLabel("Продажа");
        selll.setFont(new Font("Tames New Roman", Font.BOLD, 24));
        JLabel enterAmount = new JLabel("Введите количество продаваемых запчастей");
        JTextField amount = new JTextField("1");
        sell.addActionListener(new spareSellAction(spareId, amount));
        setLayout(null);

        add(VIN);
        add(vin);
        add(search);
        add(enterId);
        add(spareId);
        add(sell);
        add(selll);
        add(enterAmount);
        add(amount);

        Insets insets = getInsets();
        Dimension size = VIN.getPreferredSize();
        VIN.setBounds(260 + insets.left, 25 + insets.top, 200, size.height);
        size = vin.getPreferredSize();
        vin.setBounds(260 + insets.left, 50 + insets.top, 200, size.height);
        size = search.getPreferredSize();
        search.setBounds(310 + insets.left, 75 + insets.top, size.width, size.height);

        size = selll.getPreferredSize();
        selll.setBounds(320 + insets.left, 200 + insets.top, size.width, size.height);
        size = enterId.getPreferredSize();
        enterId.setBounds(130 + insets.left, 240 + insets.top, 200, size.height);
        size = spareId.getPreferredSize();
        spareId.setBounds(130 + insets.left, 265 + insets.top, 200, size.height);

        size = enterAmount.getPreferredSize();
        enterAmount.setBounds(370 + insets.left, 240 + insets.top, 200, size.height);
        size = amount.getPreferredSize();
        amount.setBounds(370 + insets.left, 265 + insets.top, 200, size.height);
        size = sell.getPreferredSize();
        sell.setBounds(310 + insets.left, 290 + insets.top, size.width, size.height);

        return this;
    }
}
