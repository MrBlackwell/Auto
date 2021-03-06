import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Cars extends JFrame {

    private int id;

    public Cars(int id) {this.id = id;}

    public void createAndShowGUI() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        ArrayList<essenceCars> cars = Main.mySQL.getListCars();
        TableModel tableModel = new carsTableModel(cars);
        JTable table = new JTable(tableModel);

        tabbedPane.addTab("Список машин", new JScrollPane(table));
        tabbedPane.addTab("Поиск и продажа", new carsSearch().createAndShowGUI(id));
        content.add(tabbedPane, BorderLayout.NORTH);
        getContentPane().add(content);
        setPreferredSize(new Dimension(700, 500));
        pack();
        setVisible(true);
    }
}
