import java.io.*;
import java.sql.*;

/**
 * Created by Валентин on 28.11.2015.
 */
public class MySQL {
    public Connection connectDataBase() {
        Connection conn = null;
        try {
            String userName = "root";
            String password = "110995";
            String url = "jdbc:mysql://localhost/test";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
            return conn;
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
            return null;
        }
    }
    public void disconnectDataBase(Connection conn) {
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { }
            }
        }
    }
}
