import javax.swing.*;
import java.awt.event.ActionEvent;


public class Rewrite extends AbstractAction {
    public void actionPerformed (ActionEvent ev) {
        Main.error.dispose();
        confirmLogin.error.dispose();
    }
}
