package com.example.postgresql.ui.repository;

import android.content.Context;

import com.example.postgresql.ui.Model.Usuari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {

    private static Repository repository;
    private Context context;

    private Repository(Context context) {
        this.context = context;
    }

    public static Repository get(Context context) {
        if (repository == null) {
            repository = new Repository(context);
        }
        return repository;
    }

    public static Repository getRepository() {
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

    public Connection startConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection;
        return connection = DriverManager.getConnection(
                "jdbc:postgresql://172.31.61.84:5432/postgres", "postgres", "1234");
    }

    public void addNewUser(Usuari usuari) throws SQLException, ClassNotFoundException {
        Connection connection = startConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into usuaris values(" + usuari.getId().toString() +
                    ",\"" + usuari.getFechaNacimiento().toString() +
                    "\",\"" + usuari.getNombre() + "\";");
        }
        catch (Exception e) {

        }
        finally {
            connection.close();
        }
    }

    public void modifyUser(int id, String nombre) throws SQLException, ClassNotFoundException {
        Connection connection = startConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update usuaris set nombre =\"" + nombre +
                    "\" where id=" + id + ";");
        }
        catch (Exception e) {
        }
        finally {
            connection.close();
        }
    }

    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        Connection connection = startConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from usuaris where id=" + id + ";");
        }
        catch (Exception e) {

        }
        finally {
            connection.close();
        }
    }
}
