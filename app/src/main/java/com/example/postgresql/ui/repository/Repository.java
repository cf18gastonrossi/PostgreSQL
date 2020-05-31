package com.example.postgresql.ui.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.postgresql.ui.models.Usuari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Repository {

    private static Repository repository;
    private Context context;
    private MutableLiveData<ArrayList<Usuari>> listaUsuaris;

    private Repository(Context context) {
        this.context = context;
        listaUsuaris = new MutableLiveData<>();
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

    public Connection startConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection;
        return connection = DriverManager.getConnection(
                "jdbc:postgresql://database-4.cwwws5ulgj4q.us-east-1.rds.amazonaws.com:5432/testDB", "sqladmin", "12341234");
    }

    public void addNewUser(Usuari usuari) {
        new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = startConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("insert into usuaris values(" + usuari.getId().toString() +
                            ",'" + usuari.getNombre() +
                            "','" + usuari.getFechaNacimiento().toString() + "');");


                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void modifyUser(int id, String nombre) {
        new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = startConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("update usuaris set nom ='" + nombre +
                            "' where id=" + id + ";");
                    ResultSet rs = statement.executeQuery("select * from usuaris;");

                    System.out.println("9");
                    while (rs.next()) {
                        System.out.println(rs.getString("nom"));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void deleteUser(int id) {
        new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = startConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("delete from usuaris where id=" + id + ";");
                    ResultSet rs = statement.executeQuery("select * from usuaris;");

                    System.out.println("9");
                    while (rs.next()) {
                        System.out.println(rs.getString("nom"));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void getUsuaris() {
        new Thread() {
            @Override
            public void run() {
                ResultSet resultSet;
                Connection connection = null;
                try {
                    connection = startConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ArrayList<Usuari> usuaris = new ArrayList<>();
                try {
                    Statement statement = connection.createStatement();
                    resultSet = statement.executeQuery("select * from usuaris;");
                    while (resultSet.next()) {
                        usuaris.add(new Usuari(resultSet.getString("nom"), resultSet.getDate("fechaNacimiento"), resultSet.getInt("id")));
                    }
                    listaUsuaris.postValue(usuaris);
                } catch (Exception e) {

                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public LiveData<ArrayList<Usuari>> getUsuarisLive() {
        return listaUsuaris;
    }
}
