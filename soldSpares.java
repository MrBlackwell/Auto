import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;


public class soldSpares extends JFrame {
    public void createAndShowGUI() {
        ArrayList<essenceSoldSpares> soldSpares = Main.mySQL.getListSoldSpares();
        TableModel tableModel = new soldSpareTableModel(soldSpares);
        JTable table = new JTable(tableModel);

        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(700, 500));
        pack();
        setVisible(true);
    }
}
