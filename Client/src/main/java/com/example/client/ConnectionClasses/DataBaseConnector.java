package com.example.client.ConnectionClasses;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;



public class DataBaseConnector {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/studs";
    private static final String USERNAME = "s367987";
    private static final String PASSWORD = "1I6o6L7H8qPAXV6X";

    public static void getConnection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Connection connection;
        Class.forName("org.postgresql.Driver");
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            CommandData.stm = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            throw e;
        }
    }
}