import javax.swing.*;
import java.awt.event.ActionEvent;


public class processSell extends AbstractAction {
    private int id;
    private JTextField carId;
    private JTextField creditNumber;
    public processSell(int id, JTextField carId, JTextField creditNumber){
        this.id = id;
        this.carId = carId;
        this.creditNumber = creditNumber;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.mySQL.soldCars(id, carId.getText(), creditNumber.getText());
    }
}
