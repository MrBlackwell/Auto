import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;


public class spares extends JFrame {
    public void createAndShowGUI() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        ArrayList<essenceSpares> spares = Main.mySQL.getListSpares();
        TableModel tableModel = new sparesTableModel(spares);
        JTable table = new JTable(tableModel);

        tabbedPane.addTab("Список запчастей", new JScrollPane(table));
        tabbedPane.addTab("Поиск и продажа", new sparesSearch().createAndShowGUI());
        content.add(tabbedPane, BorderLayout.NORTH);
        getContentPane().add(content);
        setPreferredSize(new Dimension(700, 500));
        pack();
        setVisible(true);
    }
}
