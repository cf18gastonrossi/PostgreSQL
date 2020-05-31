package com.example.postgresql.ui.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:postgresql://172.31.61.84:5432/postgres", "postgres", "1234");


                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.toString());
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(e.toString());
                    } catch (NullPointerException e) {
                        System.out.println("fail");
                    }
                }
            }
        }.start();
    }
}
