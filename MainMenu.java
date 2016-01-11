import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainMenu extends JFrame {
    public void createAndShowGUI(int id) {
        Container container = getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JButton auto = new JButton("Автомобили");
        auto.addActionListener(new CarsAction(id));

        JButton soldAuto = new JButton("Проданные автомобили");
        soldAuto.addActionListener(new soldCarsAction());

        JButton spares = new JButton("Запчасти");
        spares.addActionListener(new sparesAction());

        JButton soldSpares = new JButton("Проданные запчасти");
        soldSpares.addActionListener(new soldSpareAction());

        JButton order = new JButton("Список заказов");
        order.addActionListener(new mainMenuOrderAction());

        JButton entranceAuto = new JButton("Поступление автомобилей");
        entranceAuto.addActionListener(new entranceCarAction());

        JButton entranceSpare = new JButton("Поступление запчастей");
        entranceSpare.addActionListener(new entranceSpareAction());

        JButton exit = new JButton("Выход");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mySQL.disconnectDataBase();
                setVisible(false);
                System.exit(0);
            }
        });
        String[] arr = new String[3];
        Main.mySQL.getInfoEmployees(arr, id);
        JLabel posst = new JLabel(arr[0] + " " + arr[1] + ",      " + "Пост: " + arr[2]);
        posst.setFont(new Font("Verdana",Font.ITALIC, 15));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(auto, 200, 200, 200)
                        .addComponent(spares, 200, 200, 200)
                        .addComponent(exit, 200, 200, 200))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(posst, 300,300,300)
                        .addComponent(soldAuto, 200, 200, 200)
                        .addComponent(soldSpares, 200, 200, 200)
                        .addComponent(order, 200, 200, 200))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(entranceAuto, 200, 200, 200)
                        .addComponent(entranceSpare, 200, 200, 200))
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
                        .addComponent(exit)
                        .addComponent(order))
        //                .addComponent(fullSold))
        );

        setLocation(20,20);
        setTitle("Питер Лада");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
