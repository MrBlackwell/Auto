import javax.swing.*;
import java.awt.event.ActionEvent;


public class addCarAction extends AbstractAction {
    private JComboBox model;
    private JTextField year;
    private JTextField color;
    private JTextField power;
    private JComboBox PCC;
    private JComboBox complectation;
    private JTextField price;
    private JComboBox b_y;
    private JTextField amount;

    public addCarAction(JComboBox model, JTextField year, JTextField color, JTextField power, JComboBox PCC,
            JComboBox complectation, JTextField price, JComboBox b_y, JTextField amount) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.power = power;
        this.PCC = PCC;
        this.complectation = complectation;
        this.price = price;
        this.b_y = b_y;
        this.amount = amount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.mySQL.addCar((String)model.getSelectedItem(), year.getText(), color.getText(), power.getText(), (String)PCC.getSelectedItem(),
                (String)complectation.getSelectedItem(), price.getText(), (String)b_y.getSelectedItem(), amount.getText());
        SwingUtilities.invokeLater(()->new addingToList().createAndShowGUI());
    }
}
