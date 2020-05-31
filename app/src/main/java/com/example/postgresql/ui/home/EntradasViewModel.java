package com.example.postgresql.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.postgresql.ui.Model.Usuari;
import com.example.postgresql.ui.repository.Repository;

import java.sql.SQLException;

public class EntradasViewModel extends ViewModel {

    private Repository repository;

    public EntradasViewModel() {
        repository = Repository.getRepository();
    }

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