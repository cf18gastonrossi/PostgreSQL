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

    public void addNewUser(Usuari usuari) throws SQLException, ClassNotFoundException {
        repository.addNewUser(usuari);
    }

    public void modifyUser(int id, String nombre) throws SQLException, ClassNotFoundException {
        repository.modifyUser(id,nombre);
    }

    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        repository.deleteUser(id);
    }
}