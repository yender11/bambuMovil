package com.si.teampoison.bambu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterCitas;


import java.util.ArrayList;
import java.util.List;


public class Citas extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);



        recyclerView = (RecyclerView) findViewById(R.id.listaCitas);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Cavitacion");
        titulos.add(1,"Limpieza Facial");
        titulos.add(2,"Coco Terapia");
        titulos.add(3,"Vacunterapia");
        RecyclerViewAdapterCitas adaptador=new RecyclerViewAdapterCitas(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,cita_detalle.class);
        startActivity(i);
    }



}

