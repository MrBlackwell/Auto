import org.jetbrains.annotations.Nullable;

import java.sql.*;

/**
 * Created by Mr.Blackwell on 28.11.2015.
 */
public class MySQL {
    private static Connection connection = null;
    public static boolean connectDataBase() {
        try {
            String userName = "root";
            String password = "110995";
            String url = "jdbc:mysql://localhost/piter_lada";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
            return true;
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            return false;
        }
    }


    public static int getEmployees (String login, String password) {
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
    public static void getInfoEmployees (String[] info, int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT name, last_name, post FROM employees WHERE id=?");
            ps.setInt(1, id);
            System.out.println(ps.toString());
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

    public static void disconnectDataBase() {
        {
            if (connection != null)
            {
                try
                {
                    connection.close();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { }
            }
        }
    }
}
