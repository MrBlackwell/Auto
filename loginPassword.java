import javax.swing.*;
import java.awt.*;

/**
 * Created by Валентин on 29.11.2015.
 */
public class loginPassword extends JFrame{
    public void createAndShowGUI() {
        Container container = getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel left = new JLabel("                  ");
        JLabel please = new JLabel("Enter login and password");
        JTextField login = new JTextField(10);
        JTextField password = new JTextField((15));
        JButton okey = new JButton("OK");
        JLabel right = new JLabel("                  ");

        okey.addActionListener(new confirmLogin(login, password));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(left))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(please)
                        .addComponent(login)
                        .addComponent(password)
                        .addComponent(okey))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(right))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(left)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(please)
                                .addComponent(login)
                                .addComponent(password)
                                .addComponent(okey))
                        .addComponent(right))
        );

        setLocation(460,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
