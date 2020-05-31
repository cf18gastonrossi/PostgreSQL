package com.example.postgresql.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.postgresql.ui.Model.Usuari;
import com.example.postgresql.ui.repository.Repository;

public class HomeViewModel extends ViewModel {

    private Repository repository;

    public void addNewUser(Usuari usuari) {
        repository.addNewUser(usuari);
    }

    public void modifyUser(int id, String nombre) {
        repository.modifyUser(id,nombre);
    }

    public void deleteUser(int id) {
        repository.deleteUser(id);
    }
}