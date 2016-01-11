import javax.swing.*;
import java.awt.event.ActionEvent;


public class sparesAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(()->new spares().createAndShowGUI());
    }
}
