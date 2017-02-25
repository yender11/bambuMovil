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


public class RecyclerViewAdapterPaquetes extends RecyclerView.Adapter<ViewHolderPaquetes> {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterPaquetes(List<String> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolderPaquetes onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_paquetes, parent, false);
        ViewHolderPaquetes rvh = new ViewHolderPaquetes(v);
        return rvh;

    }

    @Override
    public void onBindViewHolder(ViewHolderPaquetes holder, int position) {
        posicion = position;
        holder.titulo.setText(datos.get(position));

    }


    @Override
    public int getItemCount() {
        return datos.size();
    }
}