package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static String url = "jdbc:mysql://localhost:3306/library_db";
    static String user = "root";
    static String password = "root123";

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(url, user, password);

    }
}