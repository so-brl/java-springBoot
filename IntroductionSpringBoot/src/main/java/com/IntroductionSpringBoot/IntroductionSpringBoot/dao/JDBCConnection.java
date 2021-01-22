package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static Connection connection;

    private static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/donjonsetdragons","root","");
    }

    public static  Connection getInstance()  throws ClassNotFoundException, SQLException{
        if (connection ==null){
            init();
        }
        return connection;
    }



}
