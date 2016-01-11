import javax.swing.*;
import java.awt.event.ActionEvent;


public class soldCarsAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(()->new soldCars().createAndShowGUI());
    }
}
