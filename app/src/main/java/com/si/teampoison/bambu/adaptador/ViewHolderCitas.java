package com.si.teampoison.bambu.adaptador;


import android.widget.TextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.si.teampoison.bambu.R;


/**
 * Created by yender on 20/02/17.
 */

public class ViewHolderCitas extends RecyclerView.ViewHolder{
    CardView cv;
    TextView titulo; //cita.codigo_servicio.descripcion
    TextView fecha; //cita.fecha
    TextView hora; //cita.hora

    ViewHolderCitas(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvCitas);
        titulo = (TextView) itemView.findViewById(R.id.textViewTituloCita);
        fecha = (TextView) itemView.findViewById(R.id.textViewFechaCita);
        hora = (TextView) itemView.findViewById(R.id.textViewHoraCita);

    }


}
