import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Валентин on 29.11.2015.
 */
public class Rewrite extends AbstractAction {
    public void actionPerformed (ActionEvent ev) {
        Main.error.dispose();
        confirmLogin.error.dispose();
    }
}
