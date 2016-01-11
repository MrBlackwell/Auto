import javax.swing.*;
import java.awt.event.ActionEvent;


public class orderAction extends AbstractAction {
    private JTextField name;
    private JTextField VIN;
    private JTextField amount;

    public orderAction(JTextField name, JTextField VIN, JTextField amount) {
        this.name = name;
        this.VIN = VIN;
        this.amount = amount;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.mySQL.addSpareForOrder(name.getText(), VIN.getText(), amount.getText());
        SwingUtilities.invokeLater(()->new addingToList().createAndShowGUI());
    }
}
