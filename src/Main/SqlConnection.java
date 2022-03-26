package Main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

    public static Connection dbConnect() {
        Connection conn = null;
        try {
            //Class.forName("com.mysql.Driver");
            Class.forName("org.sql.JDBC");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libsys","root","codecoaching");
            return conn;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

