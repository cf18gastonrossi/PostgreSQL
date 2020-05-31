package com.example.postgresql.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.postgresql.R;

public class ResultadosFragment extends Fragment {

    private ResultadosViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(ResultadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_resultados, container, false);

        return root;
    }
}