package com.si.teampoison.bambu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterNotificaciones;
import java.util.ArrayList;
import java.util.List;
public class Notificaciones extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        recyclerView = (RecyclerView) findViewById(R.id.listaNotificaciones);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Notificaciones Personalizadas");
        titulos.add(1,"Notificaciones Personalizadas");
        titulos.add(2,"Notificaciones Personalizadas");
        titulos.add(3,"Notificaciones Personalizadas");

        RecyclerViewAdapterNotificaciones adaptador=new RecyclerViewAdapterNotificaciones(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }


    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, Calificacion.class);
        startActivity(i);

    }
}