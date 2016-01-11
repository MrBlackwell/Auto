import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class searchAction extends AbstractAction {
    private JComboBox comboBoxModel;
    private JComboBox comboBoxPCC;
    private JComboBox comboBoxComplectation;
    private JComboBox comboBoxB_y;
    private JTextField year;
    private JTextField lowPower;
    private JTextField highPower;
    private JTextField lowPrice;
    private JTextField highPrice;
    private ArrayList<essenceCars> cars;
    public searchAction (JComboBox comboBoxModel, JComboBox comboBoxPCC, JComboBox comboBoxComplectation,
                         JComboBox comboBoxB_y, JTextField year, JTextField lowPower, JTextField highPower,
                         JTextField lowPrice, JTextField highPrice) {
        this.comboBoxModel = comboBoxModel;
        this.comboBoxPCC = comboBoxPCC;
        this.comboBoxComplectation = comboBoxComplectation;
        this.comboBoxB_y = comboBoxB_y;
        this.year = year;
        this.lowPower = lowPower;
        this.highPower = highPower;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cars = Main.mySQL.getSearchCars((String)comboBoxModel.getSelectedItem(),
                (String)comboBoxPCC.getSelectedItem(), (String)comboBoxComplectation.getSelectedItem(),
                (String)comboBoxB_y.getSelectedItem(), year.getText(), lowPower.getText(), highPower.getText(),
                lowPrice.getText(), highPrice.getText());

        JFrame searchResult = new JFrame();
        TableModel tableModel = new carsTableModel(cars);
        JTable table = new JTable(tableModel);
        searchResult.getContentPane().add(new JScrollPane(table));
        searchResult.setPreferredSize(new Dimension(500, 200));
        searchResult.pack();
        searchResult.setVisible(true);
    }
}
