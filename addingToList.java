import javax.swing.*;
import java.awt.*;


public class addingToList extends JFrame {
    public void createAndShowGUI() {
        JLabel complete = new JLabel("Добавление в список завершено!", SwingConstants.CENTER);
        complete.setPreferredSize(new Dimension(400, 80));
        complete.setFont(new Font("Arial",Font.PLAIN, 25));

        getContentPane().add(complete, BorderLayout.NORTH);

        setLocation(650,250);
        setVisible(true);
        pack();
    }

}