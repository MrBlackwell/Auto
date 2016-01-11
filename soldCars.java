import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;


public class soldCars extends JFrame {
    public void createAndShowGUI() {
        ArrayList<essenceSoldCars> soldcars = Main.mySQL.getListSoldCars();
        TableModel tableModel = new soldCarsTableModel(soldcars);
        JTable table = new JTable(tableModel);

        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(700, 500));
        pack();
        setVisible(true);
    }
}
