/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INT320
 */
public class ConnectionBuilder {

    private final static String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final static String URL = "jdbc:derby://localhost:1527/sample";
    private final static String USER_NAME = "app";
    private final static String PASSWORD = "app";
    private static boolean isLoaded = false;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            if (!isLoaded) {
                Class.forName(DRIVER);
                isLoaded = true;
            }
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return conn;
    }

}
