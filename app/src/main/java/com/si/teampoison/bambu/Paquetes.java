package com.si.teampoison.bambu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterPaquetes;


import java.util.ArrayList;
import java.util.List;


public class Paquetes extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.LayoutManager rc_manager;
    private RecyclerView rc_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paquetes);
        rc_view = (RecyclerView) findViewById(R.id.lista_Paquetes);
        List<String> titulos = new ArrayList<>();
        titulos.add(0, "Paquete Reductivo");
        titulos.add(1, "Paquete Aclarado");
        titulos.add(2, "Paquete Depilacion");

        RecyclerViewAdapterPaquetes adaptador = new RecyclerViewAdapterPaquetes(titulos);
        rc_manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rc_view.setLayoutManager(rc_manager);
        rc_view.setAdapter(adaptador);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, DetallePaquete.class);
        startActivity(i);
    }
}