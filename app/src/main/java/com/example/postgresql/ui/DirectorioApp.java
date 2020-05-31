package com.example.postgresql.ui;

import android.app.Application;

import com.example.postgresql.ui.repository.Repository;

public class DirectorioApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Repository.get(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
