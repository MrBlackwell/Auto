import javax.swing.*;
import java.awt.event.ActionEvent;


public class confirmLogin extends AbstractAction{
    static enterError error = new enterError();
    private JTextField login;
    private JTextField password;

    public confirmLogin(JTextField login, JTextField password){
        this.login=login;
        this.password = password;

    }
    public void actionPerformed(ActionEvent ev) {
        int id = Main.mySQL.getEmployees(login.getText(), password.getText());
        if (id != -1) {
            SwingUtilities.invokeLater(()->new MainMenu().createAndShowGUI(id));
            Main.login.dispose();
        } else {
            error.createAndShowGUI("Ошибка ввода");
        }
    }
}
