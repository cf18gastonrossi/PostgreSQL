package com.example.postgresql.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.postgresql.ui.Model.Usuari;
import com.example.postgresql.ui.repository.Repository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultadosViewModel extends ViewModel {

    private Repository repository;
    private static ArrayList<Usuari> listaUsuaris = new ArrayList<>();
    private MutableLiveData<ArrayList<Usuari>> liveDataListaUsuaris;

    public ResultadosViewModel() {
        repository = Repository.getRepository();
        liveDataListaUsuaris = new MutableLiveData<>();
        getUsuaris();
    }

    public void getUsuaris() {
        repository.getUsuaris();
        repository.getUsuarisLive().observeForever(new Observer<ArrayList<Usuari>>() {
            @Override
            public void onChanged(ArrayList<Usuari> usuaris) {
                listaUsuaris = usuaris;
                liveDataListaUsuaris.postValue(listaUsuaris);
            }
        });
    }

    public LiveData<ArrayList<Usuari>> getListaUsuaris() {
        return liveDataListaUsuaris;
    }

    public Usuari getUsuariAtPosition(int position)  {
        return listaUsuaris.get(position);
    }
}