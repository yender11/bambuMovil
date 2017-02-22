package com.si.teampoison.bambu.adaptador;


import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.si.teampoison.bambu.R;

/**
 * Created by yender on 05/02/17.
 */

public class ViewHolderNotificaciones extends RecyclerView.ViewHolder {

    CardView cv;
    TextView titulo;
    TextView contenido;
    TextView fecha;
    ImageView tipo;

    ViewHolderNotificaciones(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvNotificaciones);
        titulo = (TextView) itemView.findViewById(R.id.textViewTituloNotificacion);
        contenido = (TextView) itemView.findViewById(R.id.textViewDescripcionNotificacion);
        tipo = (ImageView) itemView.findViewById(R.id.imageViewTipoNotificacion);


    }
}
