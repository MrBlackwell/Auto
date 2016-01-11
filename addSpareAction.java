import javax.swing.*;
import java.awt.event.ActionEvent;


public class addSpareAction extends AbstractAction {
    private JTextField name;
    private JTextField price;
    private JTextField VIN_number;
    private JTextField amount;

    public addSpareAction(JTextField name, JTextField price, JTextField VIN_number, JTextField amount) {
        this.name = name;
        this.price = price;
        this.VIN_number = VIN_number;
        this.amount = amount;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.mySQL.addSpare(name.getText(), price.getText(), VIN_number.getText(), amount.getText());
        SwingUtilities.invokeLater(()->new addingToList().createAndShowGUI());
    }
}
