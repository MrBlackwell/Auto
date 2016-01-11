import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class soldSpareTableModel implements TableModel {
    Set<TableModelListener> listeners = new HashSet<>();
    List<essenceSoldSpares> soldSpares;

    public soldSpareTableModel(List<essenceSoldSpares> soldSpares) {
        this.soldSpares = soldSpares;
    }

    @Override
    public int getRowCount() {
        return soldSpares.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
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
            case 5:
                return "Дата продажи";
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
        essenceSoldSpares spare = soldSpares.get(rowIndex);
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
            case 5:
                return spare.getSelldate();
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

class essenceSoldSpares {
    private String id;
    private String name;
    private String price;
    private String VIN_number;
    private String amount;
    private String selldate;

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

    public String getSelldate() {
        return selldate;
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

    public void setSelldate(String selldate) {
        this.selldate = selldate;
    }
}
