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

public class RecyclerViewAdapterNoticias extends RecyclerView.Adapter<ViewHolderNoticias> {

    private List<String> datos;
    private int posicion;

    public RecyclerViewAdapterNoticias(List<String> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolderNoticias onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_noticias, parent, false);
        ViewHolderNoticias rvh = new ViewHolderNoticias(v);
        return rvh;

    }

    @Override
    public void onBindViewHolder(ViewHolderNoticias holder, int position) {
        posicion = position;
        holder.titulo.setText(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
