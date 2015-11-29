import javax.swing.*;

/**
 * Created by Mr.Blackwell on 25.11.2015.
 */
public class Main {
    static loginPassword loggggin = new loginPassword();
    public static void main(String[] args) {
        if (MySQL.connectDataBase()){
            loggggin.run();
        } else {

        }
    }
}
