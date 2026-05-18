package com.vti.utils;
import java.sql.*;

public class JDBCUtils {
        public static Connection getConnection(){
            String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
            String username = "root";
            String password = "pcduong1904";

            try {
                // b1: ket noi den DB
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url, username, password);
                 /*   if (connection != null) {
                        System.out.println("ket noi db thanh cong");
                    }*/

                    return connection;
                } catch (Exception e) {
                    System.out.println("ket noi database khong thanh cong");
                }

            return null;
        }

        public static void closeConnection(Connection connection, Statement statement, ResultSet rs ) throws SQLException {
            // neu cai nao co du lieu (dang mo) != null
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (rs != null){
                rs.close();
            }
        }
}