package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTuniuJdbc {

    static Connection getConn() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/tuniu";
        String username = "root";
        String password = "123456";
        Connection conn;
        Class.forName(driver); //classLoader,加载对应驱动
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
