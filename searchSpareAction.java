import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class searchSpareAction extends AbstractAction {
    private JTextField VIN_number;
    private ArrayList<essenceSpares> spares;
    public searchSpareAction(JTextField VIN_number) {
        this.VIN_number = VIN_number;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        spares = Main.mySQL.getSearchSpares(VIN_number.getText());

        JFrame searchResult = new JFrame();
        TableModel tableModel = new sparesTableModel(spares);
        JTable table = new JTable(tableModel);
        searchResult.getContentPane().add(new JScrollPane(table));
        searchResult.setPreferredSize(new Dimension(500, 200));
        searchResult.pack();
        searchResult.setVisible(true);
    }
}
