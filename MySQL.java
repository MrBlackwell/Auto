import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class MySQL extends Thread {
    private static Connection connection = null;
    private boolean ffflag = true;
    private String[] nameTable = { "cars", "employees", "orders", "soldcars", "soldspares", "spares" };

    @Override
    public void run(){
        try {
            while (ffflag) {
                sleep(200);
            }
        }
        catch (Exception e){}
    }
    public static boolean connectDataBase() {
        try {
            String userName = "root";
            String password = "110995";
            String url = "jdbc:mysql://localhost/piter_lada";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, userName, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addSpareForOrder(String name, String VIN, String amount) {
        try {
            Statement st = connection.createStatement();
            String request = "INSERT INTO orders (name, VIN_number, amount) VALUES ('%s', '%s', '%s')";
            request = String.format(request, name, VIN, amount);
            st.executeUpdate(request);
        } catch (SQLException e) {
        }
    }

    public void addCar (String model, String year, String color, String power, String PCC, String complectation,
                        String price, String b_y, String amount) {
        try {
            Statement st = connection.createStatement();
            String request = "INSERT INTO cars (model, year, color, power, PCC, complectation, price, b_y, amount) " +
                    "VALUES ('%s', %s, '%s', %s, '%s', '%s', %s, '%s', %s)";
            request = String.format(request, model, year, color, power, PCC, complectation, price, b_y, amount);
            st.executeUpdate(request);
        } catch (SQLException e) {
        }
    }

    public void addSpare (String name, String price, String VIN_number, String amount) {
        try {
            Statement st = connection.createStatement();
            String request = "INSERT INTO spares (name, price, VIN_number, amount) " +
                    "VALUES ('%s', %s, '%s', %s)";
            request = String.format(request, name, price, VIN_number, amount);
            st.executeUpdate(request);
        } catch (SQLException e) {
        }
    }

    public int getEmployees (String login, String password) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id FROM employees WHERE login=? AND password=?");
            ps.setString(1,login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return (Integer.parseInt(rs.getString(1)));
            }
            rs.close();
            ps.close();
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Nullable
    public void getInfoEmployees (String[] info, int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT name, last_name, post FROM employees WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                for (int i = 1; i <= 3; i++) {
                    info[i - 1] = rs.getString(i);
                }
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
    }

    public ArrayList<essenceCars> getListCars() {
        ArrayList<essenceCars> cars = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM cars";
            ResultSet rs = st.executeQuery(request);
            while (rs.next()){
                essenceCars car = new essenceCars();
                car.setId(rs.getString(1));
                car.setModel(rs.getString(2));
                car.setYear(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPower(rs.getString(5));
                car.setPCC(rs.getString(6));
                car.setComplectation(rs.getString(7));
                car.setPrice(rs.getString(8));
                car.setB_y(rs.getString(9));
                car.setAmount(rs.getString(10));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<essenceSoldCars> getListSoldCars() {
        ArrayList<essenceSoldCars> soldCars = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM soldcars";
            ResultSet rs = st.executeQuery(request);
            while (rs.next()){
                essenceSoldCars car = new essenceSoldCars();
                car.setId(rs.getString(1));
                car.setModel(rs.getString(2));
                car.setYear(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPower(rs.getString(5));
                car.setPCC(rs.getString(6));
                car.setComplectation(rs.getString(7));
                car.setPrice(rs.getString(8));
                car.setB_y(rs.getString(9));
                car.setNumber_credit(rs.getString(10));
                car.setSelldate(rs.getString(11));
                car.setSeller(rs.getString(12));
                soldCars.add(car);
            }
            return soldCars;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<essenceSpares> getListSpares() {
        ArrayList<essenceSpares> spares = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM spares";
            ResultSet rs = st.executeQuery(request);
            while (rs.next()){
                essenceSpares spare = new essenceSpares();
                spare.setId(rs.getString(1));
                spare.setName(rs.getString(2));
                spare.setPrice(rs.getString(3));
                spare.setVIN_number(rs.getString(4));
                spare.setAmount(rs.getString(5));
                spares.add(spare);
            }
            return spares;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<essenceSoldSpares> getListSoldSpares() {
        ArrayList<essenceSoldSpares> soldSpares = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM soldspares";
            ResultSet rs = st.executeQuery(request);
            while (rs.next()){
                essenceSoldSpares spare = new essenceSoldSpares();
                spare.setId(rs.getString(1));
                spare.setName(rs.getString(2));
                spare.setPrice(rs.getString(3));
                spare.setVIN_number(rs.getString(4));
                spare.setAmount(rs.getString(5));
                spare.setSelldate(rs.getString(6));
                soldSpares.add(spare);
            }
            return soldSpares;
        } catch (SQLException e) {
            return null;
        }
    }

    public void sellSpares (String spareId, String amount) {
        essenceSpares spare = new essenceSpares();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM spares WHERE id=%s";
            request = String.format(request, spareId);
            ResultSet rs = st.executeQuery(request);
            while(rs.next()) {
                spare.setId(rs.getString(1));
                spare.setName(rs.getString(2));
                spare.setPrice(rs.getString(3));
                spare.setVIN_number(rs.getString(4));
                spare.setAmount(rs.getString(5));
            }
            request = "INSERT INTO soldspares (name, price, VIN_number, amount, selldate) VALUES ('" + spare.getName() + "', '"
                    + spare.getPrice() + "', '" + spare.getVIN_number() + "', '" + amount + "', '%s')";
            request = String.format(request, java.util.Calendar.getInstance().getTime().toString().substring(0, 19));
            st.executeUpdate(request);
            if (Integer.parseInt(spare.getAmount()) > 1) {
                request = "UPDATE spares SET amount=" + (Integer.parseInt(spare.getAmount()) - 1) + " WHERE id=%s";
                request = String.format(request, spareId);
                st.executeUpdate(request);
            } else {
                request = "DELETE FROM spares WHERE id=%s";
                request = String.format(request, spareId);
                st.executeUpdate(request);
            }
            SwingUtilities.invokeLater(()->new sellComplete().createAndShowGUI());
        } catch (SQLException e) {

        }
    }

    public void soldCars (int id, String carsId, String creditNumber) {
        essenceCars car = new essenceCars();
        String name = "";
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM cars WHERE id=%s";
            request = String.format(request, carsId);
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                car.setId(rs.getString(1));
                car.setModel(rs.getString(2));
                car.setYear(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPower(rs.getString(5));
                car.setPCC(rs.getString(6));
                car.setComplectation(rs.getString(7));
                car.setPrice(rs.getString(8));
                car.setB_y(rs.getString(9));
                car.setAmount(rs.getString(10));
            }
            request = "SELECT name, last_name FROM employees WHERE id=%s";
            request = String.format(request, id);
            rs = st.executeQuery(request);
            while(rs.next()){
                name = name + rs.getString(1) + " " + rs.getString(2);
            }
            request = "INSERT INTO soldcars (model, year, color, power, PCC, complectation, price, b_y," +
                    " number_credit, selldate, seller) VALUES ('" + car.getModel() + "', '" + car.getYear() + "', '"
                    + car.getColor() + "', '" + car.getPower() + "', '" + car.getPCC() + "', '" + car.getComplectation()  +
                    "', '" + car.getPrice() + "', '" + car.getB_y() + "', '%s', '%s', '%s')";
            request = String.format(request, creditNumber, java.util.Calendar.getInstance().getTime().toString().substring(0, 19), name);
            st.executeUpdate(request);

            if(Integer.parseInt(car.getAmount()) > 1) {
                request = "UPDATE cars SET amount=" + (Integer.parseInt(car.getAmount()) - 1) + " WHERE id=%s";
                request = String.format(request, carsId);
                st.executeUpdate(request);
            } else {
                request = "DELETE FROM cars WHERE id=%s";
                request = String.format(request, carsId);
                st.executeUpdate(request);
            }
            SwingUtilities.invokeLater(()->new sellComplete().createAndShowGUI());
        } catch (SQLException e) {
        }
    }

    public ArrayList<essenceSpares> getSearchSpares (String VIN) {
        ArrayList<essenceSpares> spares = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM spares %s";
            String s = "";
            if (!(VIN.equals("VIN"))) {
                request = String.format(request, "WHERE VIN_number='" + VIN + "'");
            } else {
                request = String.format(request, s);
            }
            ResultSet rs = st.executeQuery(request);
            while(rs.next()){
                essenceSpares spare = new essenceSpares();
                spare.setId(rs.getString(1));
                spare.setName(rs.getString(2));
                spare.setPrice(rs.getString(3));
                spare.setVIN_number(rs.getString(4));
                spare.setAmount(rs.getString(5));
                spares.add(spare);
            }
            return spares;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<essenceCars> getSearchCars (String model, String PCC, String complectation,
                                                 String b_y, String year, String lowPower, String highPower,
                                                 String lowPrice, String highPrice) {
        ArrayList<essenceCars> cars = new ArrayList<>();
        boolean flag = false;
        try {
            Statement st = connection.createStatement();
            String request = "SELECT * FROM cars %s";
            String s = "";
            if (model != ""){
                if (!flag) {
                    flag = true;
                    s = s + "WHERE model=\'" + model + "\'";
                } else {
                    s = s + "model=\'" + model + "\'";
                }
            }
            if (PCC != ""){
                if (!flag) {
                    flag = true;
                    s = s + "WHERE PCC=\'" + PCC + "\'";
                } else {
                    s = s + " AND PCC=\'" + PCC + "\'";
                }
            }
            if (complectation != ""){
                if (!flag) {
                    flag = true;
                    s = s + "WHERE complectation=\'"+ complectation + "\'";
                } else {
                    s = s + " AND complectation=\'" + complectation + "\'";
                }
            }
            if (b_y != ""){
                if (!flag) {
                    flag = true;
                    s = s + "WHERE b_y=\'"+ b_y + "\'";
                } else {
                    s = s + " AND b_y=\'" + b_y + "\'";
                }
            }
            if (!(year.equals("Enter year"))) {
                if (!flag) {
                    flag = true;
                    s = s + "WHERE year=\'"+ year + "\'";
                } else {
                    s = s + " AND year=\'" + year + "\'";
                }
            }
            if (!(lowPower.equals("Enter low power"))) {
                if (!(highPower.equals("Enter high power"))) {
                    if (!flag) {
                        flag = true;
                        s = s + "WHERE power BETWEEN \'" + lowPower + "\' AND \'" + highPower + "\'";
                    } else {
                        s = s + " AND power BETWEEN \'" + lowPower + "\' AND \'" + highPower + "\'";
                    }
                }
                else {
                    if (!flag) {
                        flag = true;
                        s = s + "WHERE power >=\'" + lowPower + "\'";
                    } else {
                        s = s + " AND power >=\'" + lowPower + "\'";
                    }
                }
            }
            else {
                if (!(highPower.equals("Enter high power"))) {
                    if (!flag) {
                        flag = true;
                        s = s + "WHERE power <=\'" + highPower + "\'";
                    } else {
                        s = s + " AND power <=\'" + highPower + "\'";
                    }
                }
            }
            if (!(lowPrice.equals("Enter low price"))) {
                if (!(highPrice.equals("Enter high price"))) {
                    if (!flag){
                        flag = true;
                        s = s + "WHERE price BETWEEN \'" + lowPrice + "\' AND \'" + highPrice + "\'";
                    } else {
                        s = s + " AND price BETWEEN \'" + lowPrice + "\' AND \'" + highPrice + "\'";
                    }
                }
                else {
                    if (!flag){
                        flag = true;
                        s = s + "WHERE price >=\'" + lowPrice + "\'";
                    } else {
                        s = s + " AND price >=\'" + lowPrice + "\'";
                    }
                }
            }
            else {
                if (!(highPrice.equals("Enter high price"))) {
                    if (!flag) {
                        flag = true;
                        s = s + "WHERE price <=\'" + highPrice + "\'";
                    } else {
                        s = s + " AND price <=\'" + highPrice + "\'";
                    }
                }
            }
            request = String.format(request, s);
            ResultSet rs = st.executeQuery(request);
            while (rs.next()){
                essenceCars car = new essenceCars();
                car.setId(rs.getString(1));
                car.setModel(rs.getString(2));
                car.setYear(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPower(rs.getString(5));
                car.setPCC(rs.getString(6));
                car.setComplectation(rs.getString(7));
                car.setPrice(rs.getString(8));
                car.setB_y(rs.getString(9));
                car.setAmount(rs.getString(10));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            return null;
        }
    }

    public void disconnectDataBase() {
        {
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e) { }
            }
            ffflag = false;
        }
    }
}
