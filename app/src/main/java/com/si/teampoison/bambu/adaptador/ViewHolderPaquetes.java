package com.si.teampoison.bambu.adaptador;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.si.teampoison.bambu.R;


/**
 * Created by yender on 20/02/17.
 */

public class ViewHolderPaquetes extends RecyclerView.ViewHolder{
    CardView cv;
    TextView titulo;
    TextView fecha; //fecha ultima sesion
    TextView num_sesion; //numero de la ultima sesion

    ViewHolderPaquetes(View itemView){
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cvPaquetes);
        titulo = (TextView) itemView.findViewById(R.id.textV_paquete);
        fecha = (TextView) itemView.findViewById(R.id.textV_fecha_sesion);
        num_sesion = (TextView) itemView.findViewById(R.id.textV_num_sesion);

    }
    }
