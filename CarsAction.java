import javax.swing.*;
import java.awt.event.ActionEvent;


public class CarsAction extends AbstractAction {

    public int id;

    public CarsAction (int id) {
        this.id = id;
    }
    public void actionPerformed(ActionEvent ev) {
        SwingUtilities.invokeLater(()->new Cars(id).createAndShowGUI());
    }
}
