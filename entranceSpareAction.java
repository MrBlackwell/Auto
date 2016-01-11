import javax.swing.*;
import java.awt.event.ActionEvent;


public class entranceSpareAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(()->new entranceSpares().createAndShowGUI());
    }
}
