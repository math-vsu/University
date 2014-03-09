package ru.vsu.math.java.entity;
import java.sql.*;
/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 07.03.14
 * Time: 8:55
 * To change this template use File | Settings | File Templates.
 */
public class DbConnection {
    public static Connection get(String DbName){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:" + SQLRecord.dbName, "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return conn;
    }
}
