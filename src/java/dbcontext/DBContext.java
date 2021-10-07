/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DucAnh
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "localhost";
    private final String dbName = "SWP391";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";

    public static void main(String[] args) {
        new DBContext();
    }
}
