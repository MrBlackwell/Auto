import javax.swing.*;
import java.awt.*;


public class carsSearch extends JPanel {
    public JPanel createAndShowGUI(int id) {
        String[] itemModel = {
                "",
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
                "",
                "MPCC",
                "APCC"
        };
        JComboBox comboBoxPCC = new JComboBox(itemPCC);

        String[] itemComplectation = {
                "",
                "Minimal",
                "Normal",
                "Lux"
        };
        JComboBox comboBoxComplectation = new JComboBox(itemComplectation);

        String[] itemB_y = {
                "",
                "Yes",
                "No"
        };
        JComboBox comboBoxB_y = new JComboBox(itemB_y);

        JTextField year = new JTextField("Год выпуска");
        JTextField lowPower = new JTextField("Мин. мощность");
        JTextField highPower = new JTextField("Макс. мощность");
        JTextField lowPrice = new JTextField("Миню цена");
        JTextField highPrice = new JTextField("Макс. цена");
        JButton die = new JButton("Поиск");
        die.addActionListener(new searchAction(comboBoxModel, comboBoxPCC, comboBoxComplectation,
                comboBoxB_y, year, lowPower, highPower, lowPrice, highPrice));
        JLabel model = new JLabel("Выберите модель");
        JLabel PCC = new JLabel("Выберите тип КПП");
        JLabel complectation = new JLabel("Выберите комплектацию");
        JLabel b_y = new JLabel("Новый или б/у?");
        JLabel credit_number = new JLabel("Введите номер кредитлного договора");
        JLabel enterId = new JLabel("Введите id продаваемой машины");
        JTextField number_credit = new JTextField();
        JTextField idEnter = new JTextField();
        JButton sell = new JButton("Продать");
        JLabel selll = new JLabel("Продажа");
        selll.setFont(new Font("Times New Roman", Font.BOLD, 24));
        sell.addActionListener(new processSell(id, idEnter, number_credit));

        setLayout(null);

        add(comboBoxModel);
        add(comboBoxPCC);
        add(comboBoxComplectation);
        add(comboBoxB_y);
        add(year);
        add(lowPower);
        add(highPower);
        add(lowPrice);
        add(highPrice);
        add(die);
        add(model);
        add(PCC);
        add(complectation);
        add(b_y);
        add(credit_number);
        add(number_credit);
        add(enterId);
        add(idEnter);
        add(sell);
        add(selll);


        Insets insets = getInsets();
        Dimension size = model.getPreferredSize();
        model.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
        size = comboBoxModel.getPreferredSize();
        comboBoxModel.setBounds(25 + insets.left, 30 + insets.top, size.width, size.height);
        size = PCC.getPreferredSize();
        PCC.setBounds(25 + insets.left, 55 + insets.top, size.width, size.height);
        size = comboBoxPCC.getPreferredSize();
        comboBoxPCC.setBounds(25 + insets.left, 80 + insets.top, size.width, size.height);
        size = complectation.getPreferredSize();
        complectation.setBounds(25 + insets.left, 105 + insets.top, size.width, size.height);
        size = comboBoxComplectation.getPreferredSize();
        comboBoxComplectation.setBounds(25 + insets.left, 130 + insets.top, size.width, size.height);
        size = b_y.getPreferredSize();
        b_y.setBounds(25 + insets.left, 155 + insets.top, size.width, size.height);
        size = comboBoxB_y.getPreferredSize();
        comboBoxB_y.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);

        year.setBounds(325 + insets.left, 30 + insets.top, 100, 20);
        lowPower.setBounds(325 + insets.left, 80 + insets.top, 100, 20);
        highPower.setBounds(450 + insets.left, 80 + insets.top, 100, 20);
        lowPrice.setBounds(325 + insets.left, 130 + insets.top, 100, 20);
        highPrice.setBounds(450 + insets.left, 130 + insets.top, 100, 20);
        size = die.getPreferredSize();
        die.setBounds(325 + insets.left, 180 + insets.top, size.width, size.height);

        size = selll.getPreferredSize();
        selll.setBounds(300 + insets.left, 220 + insets.top, size.width, size.height);
        size = credit_number.getPreferredSize();
        credit_number.setBounds(80 + insets.left, 270 + insets.top, size.width, size.height);
        size = number_credit.getPreferredSize();
        number_credit.setBounds(80 + insets.left, 295 + insets.top, 200, size.height);
        size = enterId.getPreferredSize();
        enterId.setBounds(320 + insets.left, 270 + insets.top, size.width, size.height);
        size = idEnter.getPreferredSize();
        idEnter.setBounds(320 + insets.left, 295 + insets.top, 200, size.height);

        sell.setBounds(500 + insets.left, 360 + insets.top, 100, 50);
        return this;
    }
}
