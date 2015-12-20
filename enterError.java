import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Валентин on 29.11.2015.
 */
public class enterError extends JFrame {
    public void createAndShowGUI(String errorstr) {
        JLabel error = new JLabel(errorstr + "!", SwingConstants.CENTER);
        error.setPreferredSize(new Dimension(200, 80));
        error.setFont(new Font("Arial", Font.PLAIN, 25));
        JButton okey = new JButton("OK");

        getContentPane().add(error, BorderLayout.NORTH);
        getContentPane().add(okey, BorderLayout.SOUTH);

        okey.addActionListener(new Rewrite());

        setLocation(520,250);
        setVisible(true);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
