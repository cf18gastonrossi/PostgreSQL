package com.example.postgresql.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postgresql.R;
import com.example.postgresql.ui.Model.Usuari;
import com.example.postgresql.ui.RecyclerView.Adapter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultadosFragment extends Fragment {

    private ResultadosViewModel resultadosViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Usuari> usuarisList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultadosViewModel =
                ViewModelProviders.of(this).get(ResultadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_resultados, container, false);


        setUpRecyclerView(root);
        return root;
    }

    private void setUpRecyclerView(View view) {

        resultadosViewModel.getListaUsuaris().observe(getViewLifecycleOwner(), new Observer<ArrayList<Usuari>>() {
            @Override
            public void onChanged(ArrayList<Usuari> usuaris) {
                usuarisList = usuaris;
                mAdapter = new Adapter(usuarisList);
                recyclerView.setAdapter(mAdapter);
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new Adapter(usuarisList);
        recyclerView.setAdapter(mAdapter);

    }

}