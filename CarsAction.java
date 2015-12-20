import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Валентин on 29.11.2015.
 */
public class CarsAction extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
        SwingUtilities.invokeLater(()->new Cars().createAndShowGUI());
    }
}
