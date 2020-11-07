package inventory.models;

import java.sql.*;

public class DB {
    public static Connection con;

    public DB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_inventory?useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "root");
        } catch(Exception e){ System.out.println("Could not connect to the database. More detailed error: " + e.getMessage()); }
    }
}
