package com.si.teampoison.bambu.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.si.teampoison.bambu.R;

import java.util.List;

/**
 * Created by yender on 20/02/17.
 */


public class RecyclerViewAdapterCitas extends RecyclerView.Adapter<ViewHolderCitas> {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterCitas(List<String> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolderCitas onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_citas, parent, false);
        ViewHolderCitas rvh = new ViewHolderCitas(v);
        return rvh;

    }

    @Override
    public void onBindViewHolder(ViewHolderCitas holder, int position) {
        posicion = position;
        holder.titulo.setText(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}