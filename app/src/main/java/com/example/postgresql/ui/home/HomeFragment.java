package com.example.postgresql.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.postgresql.R;
import com.example.postgresql.ui.Model.Usuari;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView idAgregar, nombreAgregar, fechaAgregar, idModificar, nombreModificar, idEliminar;
    private Button agregar, modificar, eliminar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrada, container, false);

        setUpListener(root);
        return root;
    }

    private void setUpListener(View view) {
        idAgregar = view.findViewById(R.id.idAgregar);
        nombreAgregar = view.findViewById(R.id.nombreAgregar);
        fechaAgregar = view.findViewById(R.id.fechaAgregar);
        idModificar = view.findViewById(R.id.idModifcar);
        nombreModificar = view.findViewById(R.id.nombreModificar);
        idEliminar = view.findViewById(R.id.idEliminar);
        agregar = view.findViewById(R.id.agregarButton);
        modificar = view.findViewById(R.id.modificarButton);
        eliminar = view.findViewById(R.id.eliminarButton);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Usuari.checkInput(nombreAgregar.getText().toString(), fechaAgregar.getText().toString(), Integer.parseInt(idAgregar.getText().toString()))) {
                        homeViewModel.addNewUser(new Usuari(
                                nombreAgregar.getText().toString(),
                                Date.valueOf(fechaAgregar.getText().toString()),
                                Integer.parseInt(idAgregar.getText().toString())));
                    }
                } catch (Exception e) {
                }
            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!idModificar.getText().toString().equalsIgnoreCase("") || !nombreModificar.getText().toString().equalsIgnoreCase("")){
                        homeViewModel.modifyUser(Integer.parseInt(idModificar.getText().toString()),nombreModificar.getText().toString());
                    }
                }
                catch (Exception e) {

                }
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!idEliminar.getText().toString().equalsIgnoreCase("")){
                        homeViewModel.deleteUser(Integer.parseInt(idEliminar.getText().toString()));
                    }
                }
                catch (Exception e) {}
            }
        });
    }


}