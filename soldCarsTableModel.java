import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class soldCarsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<essenceSoldCars> soldCars;

    public soldCarsTableModel(List<essenceSoldCars> soldCars) {
        this.soldCars = soldCars;
    }

    @Override
    public int getRowCount() {
        return soldCars.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
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
                return "Номер кред.";
            case 10:
                return "Дата продаже";
            case 11:
                return "Продавец";
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
        essenceSoldCars soldCar = soldCars.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return soldCar.getId();
            case 1:
                return soldCar.getModel();
            case 2:
                return soldCar.getYear();
            case 3:
                return soldCar.getColor();
            case 4:
                return soldCar.getPower();
            case 5:
                return soldCar.getPCC();
            case 6:
                return soldCar.getComplectation();
            case 7:
                return soldCar.getPrice();
            case 8:
                return soldCar.getB_y();
            case 9:
                return soldCar.getNumber_credit();
            case 10:
                return soldCar.getSelldate();
            case 11:
                return soldCar.getSeller();
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

class essenceSoldCars {
    private String id;
    private String model;
    private String year;
    private String color;
    private String power;
    private String PCC;
    private String complectation;
    private String price;
    private String b_y;
    private String number_credit;
    private String selldate;
    private String seller;


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

    public String getNumber_credit() {
        return number_credit;
    }

    public String getSelldate() {
        return selldate;
    }

    public String getSeller() {
        return seller;
    }

    public void setNumber_credit(String number_credit) {
        this.number_credit = number_credit;
    }

    public void setSelldate(String selldate) {
        this.selldate = selldate;
    }

    public void setSeller(String seller) {
        this.seller = seller;
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

}
