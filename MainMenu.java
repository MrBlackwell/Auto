import java.awt.*;
import javax.swing.*;

/**
 * Created by Mr.Blackwell on 24.11.2015.
 */
public class MainMenu extends JFrame {
    public void createAndShowGUI(int id) {
        Container container = getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);


        JButton employees = new JButton("Employees");
        JButton auto = new JButton("Cars");
        auto.addActionListener(new CarsAction());
        JButton soldAuto = new JButton("Sold cars");
        JButton spares = new JButton("Spares");
        JButton soldSpares = new JButton("Sold spares");
        JButton order = new JButton("List to order");
        JButton entranceAuto = new JButton("Entrance of cars");
        JButton entranceSpare = new JButton("Entrance of spares");
        JButton fullSold = new JButton("The grand total of sales");
        String[] arr = new String[3];
        Main.mySQL.getInfoEmployees(arr, id);
        JLabel posst = new JLabel(arr[0] + " " + arr[1] + ",      " + "Post: " + arr[2]);
        posst.setFont(new Font("Verdana",Font.ITALIC, 15));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(auto, 200, 200, 200)
                        .addComponent(spares, 200, 200, 200)
                        .addComponent(employees, 200, 200, 200))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(posst, 300,300,300)
                        .addComponent(soldAuto, 200, 200, 200)
                        .addComponent(soldSpares, 200, 200, 200)
                        .addComponent(order, 200, 200, 200))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(entranceAuto, 200, 200, 200)
                        .addComponent(entranceSpare, 200, 200, 200)
                        .addComponent(fullSold, 200, 200, 200))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(posst))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(auto)
                        .addComponent(soldAuto)
                        .addComponent(entranceAuto))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(posst)
                        .addComponent(spares)
                        .addComponent(soldSpares)
                        .addComponent(entranceSpare))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(employees)
                        .addComponent(order)
                        .addComponent(fullSold))
        );

        setLocation(20,20);
        setTitle("Piter Lada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
