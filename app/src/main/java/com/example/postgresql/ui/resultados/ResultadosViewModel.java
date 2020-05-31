package com.example.postgresql.ui.resultados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.postgresql.ui.models.Usuari;
import com.example.postgresql.ui.repository.Repository;

import java.util.ArrayList;

public class ResultadosViewModel extends ViewModel {

    Repository repository;
    ArrayList<Usuari> listaUsuaris;
    MutableLiveData<ArrayList<Usuari>> liveDataListaUsuaris;

    public ResultadosViewModel() {
        repository = Repository.getRepository();
        listaUsuaris = new ArrayList<>();
        liveDataListaUsuaris = new MutableLiveData<>();
    }

    public void getUsuaris() {
        repository.getUsuaris();
        System.out.println("1");
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
}