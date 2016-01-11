import javax.swing.*;
import java.awt.*;


public class sellComplete extends JFrame {
    public void createAndShowGUI() {
        JLabel complete = new JLabel("Продажа совершена!", SwingConstants.CENTER);
        complete.setPreferredSize(new Dimension(200, 80));
        complete.setFont(new Font("Arial",Font.PLAIN, 25));

        getContentPane().add(complete, BorderLayout.NORTH);

        setLocation(600,250);
        setVisible(true);
        pack();
    }

}
