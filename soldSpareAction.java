import javax.swing.*;
import java.awt.event.ActionEvent;


public class soldSpareAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(()->new soldSpares().createAndShowGUI());
    }
}
