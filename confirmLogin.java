import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Валентин on 29.11.2015.
 */
public class confirmLogin extends AbstractAction{
    private JTextField login;
    private JTextField password;
    public confirmLogin(JTextField login, JTextField password){
        this.login=login;
        this.password = password;

    }
    public void actionPerformed(ActionEvent ev) {
        int id = MySQL.getEmployees(login.getText(), password.getText());
        System.out.println(id);
        if (id != -1) {
            SwingUtilities.invokeLater(()->new MainMenu().createAndShowGUI(id));
            Main.loggggin.dispose();
        } else
        {
        }
    }
}
