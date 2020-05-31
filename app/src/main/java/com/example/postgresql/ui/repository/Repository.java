package com.example.postgresql.ui.repository;

import android.content.Context;

import com.example.postgresql.ui.Model.Usuari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    private static Repository repository;
    private Context context;

    private Repository(Context context) {
        this.context = context;
    }

    public static Repository getRepository(Context context) {
        if (repository == null) {
            repository = new Repository(context);
        }
        return repository;
    }

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

    public void addNewUser(Usuari usuari) {
    }

    public void modifyUser(int id, String nombre) {
    }

    public void deleteUser(int id) {
    }
}
