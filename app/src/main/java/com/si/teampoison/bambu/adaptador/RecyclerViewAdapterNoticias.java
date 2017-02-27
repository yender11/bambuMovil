package com.si.teampoison.bambu.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.si.teampoison.bambu.R;
import com.si.teampoison.bambu.sql.dao.NoticiaDAO;
import com.si.teampoison.bambu.sql.modelo.Noticia;

import java.util.List;

/**
 * Created by yender on 20/02/17.
 */

public class RecyclerViewAdapterNoticias extends RecyclerView.Adapter<ViewHolderNoticias> {

    private List<Noticia> noticias;
    private int posicion;


    public RecyclerViewAdapterNoticias(List<Noticia> noticias)
    {
        this.noticias = noticias;
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

        holder.descripccion.setText(noticias.get(position).getDescripcion());
        holder.titulo.setText(noticias.get(position).getStatus()); // ojooo falta atributo en la db
        holder.fecha.setText(noticias.get(position).getFecha());

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }


}
