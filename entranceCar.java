import javax.swing.*;
import java.awt.*;


public class entranceCar extends JFrame {
    public void createAndShowGUI() {
        String[] itemModel = {
                "2101",
                "2102",
                "2103",
                "2104",
                "2105",
                "2106",
                "2107",
                "2108",
                "2109",
                "21010",
                "21011",
                "21012",
                "21013",
                "21014",
                "21015",
                "Kalina",
                "Granta",
                "Priora",
                "Largus",
                "Niva 4x4",
                "Largus",
                "Vesta"
        };
        JComboBox comboBoxModel = new JComboBox(itemModel);

        String[] itemPCC = {
                "MPCC",
                "APCC"
        };
        JComboBox comboBoxPCC = new JComboBox(itemPCC);

        String[] itemComplectation = {
                "Minimal",
                "Normal",
                "Lux"
        };
        JComboBox comboBoxComplectation = new JComboBox(itemComplectation);

        String[] itemB_y = {
                "Yes",
                "No"
        };
        JComboBox comboBoxB_y = new JComboBox(itemB_y);

        JLabel model = new JLabel("Модель:");
        JLabel PCC = new JLabel("КПП:");
        JLabel complectation = new JLabel("Комплектация:");
        JLabel b_y = new JLabel("Б/у:");
        JLabel Year = new JLabel("Год выпуска:");
        JLabel Color = new JLabel("Цвет:");
        JLabel Power = new JLabel("Мощность:");
        JLabel Price = new JLabel("Цена");
        JLabel Amount = new JLabel("Количество:");
        JTextField year = new JTextField();
        JTextField color = new JTextField();
        JTextField power = new JTextField();
        JTextField price = new JTextField();
        JTextField amount = new JTextField();
        JButton addd = new JButton("Добавить");
        addd.addActionListener(new addCarAction(comboBoxModel, year, color, power, comboBoxPCC, comboBoxComplectation, price, comboBoxB_y, amount));

        setLayout(null);

        add(comboBoxModel);
        add(comboBoxPCC);
        add(comboBoxComplectation);
        add(comboBoxB_y);
        add(year);
        add(color);
        add(power);
        add(price);
        add(amount);
        add(model);
        add(PCC);
        add(complectation);
        add(b_y);
        add(Year);
        add(Color);
        add(Power);
        add(Price);
        add(Amount);
        add(addd);

        Insets insets = getInsets();
        Dimension size = model.getPreferredSize();
        model.setBounds(25 + insets.left, 25 + insets.top, size.width, size.height);
        size = comboBoxModel.getPreferredSize();
        comboBoxModel.setBounds(25 + insets.left, 45 + insets.top, size.width, size.height);
        size = PCC.getPreferredSize();
        PCC.setBounds(25 + insets.left, 75 + insets.top, size.width, size.height);
        size = comboBoxPCC.getPreferredSize();
        comboBoxPCC.setBounds(25 + insets.left, 95 + insets.top, size.width, size.height);
        size = b_y.getPreferredSize();
        b_y.setBounds(25 + insets.left, 125+ insets.top, size.width, size.height);
        size = comboBoxB_y.getPreferredSize();
        comboBoxB_y.setBounds(25 + insets.left, 145 + insets.top, size.width, size.height);
        size = complectation.getPreferredSize();
        complectation.setBounds(25 + insets.left, 175 + insets.top, size.width, size.height);
        size = comboBoxComplectation.getPreferredSize();
        comboBoxComplectation.setBounds(25 + insets.left, 195 + insets.top, size.width, size.height);
        size = addd.getPreferredSize();
        addd.setBounds(25 + insets.left, 250 + insets.top, size.width, size.height);

        size = Year.getPreferredSize();
        Year.setBounds(225 + insets.left, 25 + insets.top, size.width, size.height);
        size = year.getPreferredSize();
        year.setBounds(225 + insets.left, 50 + insets.top, 100, size.height);
        size = Color.getPreferredSize();
        Color.setBounds(225 + insets.left, 75 + insets.top, size.width, size.height);
        size = color.getPreferredSize();
        color.setBounds(225 + insets.left, 100 + insets.top, 100, size.height);
        size = Power.getPreferredSize();
        Power.setBounds(225 + insets.left, 125 + insets.top, size.width, size.height);
        size = power.getPreferredSize();
        power.setBounds(225 + insets.left, 150 + insets.top, 100, size.height);
        size = Price.getPreferredSize();
        Price.setBounds(225 + insets.left, 175 + insets.top, size.width, size.height);
        size = price.getPreferredSize();
        price.setBounds(225 + insets.left, 200 + insets.top, 100, size.height);
        size = Amount.getPreferredSize();
        Amount.setBounds(225 + insets.left, 225 + insets.top, size.width,size.height);
        size = amount.getPreferredSize();
        amount.setBounds(225 + insets.left, 250 + insets.top, 100, size.height);


        setPreferredSize(new Dimension(450, 320));
        pack();
        setVisible(true);
    }
}
