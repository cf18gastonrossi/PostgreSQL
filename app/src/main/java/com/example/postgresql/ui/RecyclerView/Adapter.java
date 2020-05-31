package com.example.postgresql.ui.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postgresql.R;
import com.example.postgresql.ui.Model.Usuari;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<Usuari> usuariList;

    public Adapter(ArrayList<Usuari> entryList) {
        this.usuariList = entryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        String nombre = usuariList.get(i).getNombre();
        String id = usuariList.get(i).getId().toString();
        String fecha = usuariList.get(i).getFechaNacimiento().toString();

        holder.nombre.setText(nombre);
        holder.id.setText(id);
        holder.fecha.setText(fecha);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return usuariList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre, id, fecha;

        public MyViewHolder(View v) {
            super(v);

            nombre = v.findViewById(R.id.nombre);
            id = v.findViewById(R.id.id);
            fecha = v.findViewById(R.id.fecha);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("POSITION", getAdapterPosition());
                    Navigation.findNavController(view).navigate(R.id.usuariFragment, bundle);
                }
            });
        }
    }
}

