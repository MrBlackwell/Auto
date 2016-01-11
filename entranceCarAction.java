import javax.swing.*;
import java.awt.event.ActionEvent;


public class entranceCarAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(()-> new entranceCar().createAndShowGUI());
    }
}
