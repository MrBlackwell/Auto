import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class sparesTableModel implements TableModel {
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<essenceSpares> spares;

    public sparesTableModel(List<essenceSpares> spares) {
        this.spares = spares;
    }

    @Override
    public int getRowCount() {
        return spares.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "Название";
            case 2:
                return "Цена";
            case 3:
                return "VIN номер";
            case 4:
                return "Количество";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        essenceSpares spare = spares.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return spare.getId();
            case 1:
                return spare.getName();
            case 2:
                return spare.getPrice();
            case 3:
                return spare.getVIN_number();
            case 4:
                return spare.getAmount();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}

class essenceSpares {
    private String id;
    private String name;
    private String price;
    private String VIN_number;
    private String amount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getVIN_number() {
        return VIN_number;
    }

    public String getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVIN_number(String VIN_number) {
        this.VIN_number = VIN_number;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}