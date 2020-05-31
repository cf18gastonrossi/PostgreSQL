package com.example.postgresql.ui.usuari;

import androidx.lifecycle.ViewModel;

import com.example.postgresql.ui.models.Usuari;
import com.example.postgresql.ui.repository.Repository;

import java.util.ArrayList;

public class UsuariViewModel extends ViewModel {

    Repository repository;
    ArrayList<Usuari> listaUsuaris;

    private UsuariViewModel() {
        repository = Repository.getRepository();
        listaUsuaris = new ArrayList<>();
    }


    public Usuari getUsuariAtPosition(int position)  {
        repository.getUsuaris();
        repository.getUsuarisLive().observeForever(usuaris -> {
            listaUsuaris = usuaris;
        });
        return listaUsuaris.get(position);
    }
}
