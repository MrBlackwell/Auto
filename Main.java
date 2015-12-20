import javax.swing.*;

/**
 * Created by Mr.Blackwell on 25.11.2015.
 */
public class Main {
    static loginPassword login = new loginPassword();
    static enterError error = new enterError();
    static MySQL mySQL = new MySQL();
    public static void main(String[] args) {
        mySQL.start();
        if (mySQL.connectDataBase()){
            SwingUtilities.invokeLater(()->new MainMenu().createAndShowGUI(1));
            //login.createAndShowGUI();
        } else {
            error.createAndShowGUI("Error connect to database");
        }
    }
}
