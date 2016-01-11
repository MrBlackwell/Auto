import javax.swing.*;
import java.awt.event.ActionEvent;


public class spareSellAction extends AbstractAction {
    private JTextField spareId;
    private JTextField amount;

    public spareSellAction(JTextField spareId, JTextField amount) {
        this.spareId = spareId;
        this.amount = amount;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.mySQL.sellSpares(spareId.getText(), amount.getText());
    }
}
