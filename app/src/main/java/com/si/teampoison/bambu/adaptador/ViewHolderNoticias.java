package com.si.teampoison.bambu.adaptador;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.si.teampoison.bambu.R;

/**
 * Created by yender on 20/02/17.
 */

public class ViewHolderNoticias extends RecyclerView.ViewHolder{
    CardView cv;
    TextView titulo; //noticia.titulo
    TextView fecha; //noticia.fecha
    TextView descripccion; //noticia.descripcion
    ImageView icono;

    ViewHolderNoticias(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvNoticias);
        titulo = (TextView) itemView.findViewById(R.id.textViewTituloNoticia);
        descripccion =(TextView) itemView.findViewById(R.id.textViewDescripcionNoticia);
        fecha = (TextView) itemView.findViewById(R.id.textViewFechaNoticia);
        icono = (ImageView) itemView.findViewById(R.id.imageViewIconoNoticia);

    }


}
