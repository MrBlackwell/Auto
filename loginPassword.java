import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class loginPassword extends JFrame{
    public void createAndShowGUI() {
        Container container = getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel left = new JLabel("                  ");
        JLabel please = new JLabel("Введите логин и пароль");
        JTextField login = new JTextField(10);
        JTextField password = new JTextField((15));
        JButton okey = new JButton("OK");
        JLabel right = new JLabel("                  ");
        JButton exit = new JButton("Выход");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mySQL.disconnectDataBase();
                setVisible(false);
                System.exit(0);
            }
        });

        okey.addActionListener(new confirmLogin(login, password));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(left))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(please)
                        .addComponent(login)
                        .addComponent(password)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(okey)
                                .addComponent(exit)))
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
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(okey)
                                        .addComponent(exit)))
                        .addComponent(right))
        );

        setLocation(460,250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
