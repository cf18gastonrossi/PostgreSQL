package com.example.postgresql;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(
                            "jdbc:postgresql://database-4.cwwws5ulgj4q.us-east-1.rds.amazonaws.com:5432/testDB", "sqladmin", "12341234");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("select * from usuaris;");
                    while (rs.next()){
                        System.out.println(rs.getString("nom"));
                    }
                    System.out.println("asdfas");


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
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.navView);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigationEntrada, R.id.navigationResultado)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }



}
