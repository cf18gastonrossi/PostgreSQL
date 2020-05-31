package com.example.postgresql.ui.usuari;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.postgresql.R;
import com.example.postgresql.ui.Model.Usuari;

import java.sql.SQLException;


public class UsuariFragment extends Fragment {

    private UsuariViewModel usuariViewModel;
    private TextView id, nombre, fechaNacimiento;

    public UsuariFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        usuariViewModel =
                ViewModelProviders.of(this).get(UsuariViewModel.class);
        View root = inflater.inflate(R.layout.fragment_usuari, container, false);

        id = root.findViewById(R.id.idRespuesta);
        nombre = root.findViewById(R.id.nombreRespuesta);
        fechaNacimiento = root.findViewById(R.id.fechaNacimiento);

        updateUsuari(usuariViewModel.getUsuariAtPosition(getArguments().getInt("POSITION")));

        return root;
    }

    public void updateUsuari(Usuari usuari) {
        id.setText(usuari.getId());
        nombre.setText(usuari.getNombre());
        fechaNacimiento.setText(usuari.getFechaNacimiento().toString());
    }
}
