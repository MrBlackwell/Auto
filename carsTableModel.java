import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class carsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<essenceCars> cars;

    public carsTableModel(List<essenceCars> cars) {
        this.cars = cars;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "Модель";
            case 2:
                return "Год";
            case 3:
                return "Цвет";
            case 4:
                return "Мощность";
            case 5:
                return "КПП";
            case 6:
                return "Комплектация";
            case 7:
                return "Цена";
            case 8:
                return "Б/у";
            case 9:
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
        essenceCars car = cars.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return car.getId();
            case 1:
                return car.getModel();
            case 2:
                return car.getYear();
            case 3:
                return car.getColor();
            case 4:
                return car.getPower();
            case 5:
                return car.getPCC();
            case 6:
                return car.getComplectation();
            case 7:
                return car.getPrice();
            case 8:
                return car.getB_y();
            case 9:
                return car.getAmount();
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
class essenceCars {
    private String id;
    private String model;
    private String year;
    private String color;
    private String power;
    private String PCC;
    private String complectation;
    private String price;
    private String b_y;
    private String amount;

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPower() {
        return power;
    }

    public String getPCC() {
        return PCC;
    }

    public String getComplectation() {
        return complectation;
    }

    public String getPrice() {
        return price;
    }

    public String getB_y() {
        return b_y;
    }

    public String getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setPCC(String PCC) {
        this.PCC = PCC;
    }

    public void setComplectation(String complectation) {
        this.complectation = complectation;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setB_y(String b_y) {
        this.b_y = b_y;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
