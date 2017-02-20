package com.si.teampoison.bambu;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterCitas;


import java.util.ArrayList;
import java.util.List;


public class Citas extends AppCompatActivity  {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        recyclerView = (RecyclerView) findViewById(R.id.listaCitas);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Cabitacion");
        titulos.add(1,"Limpieza Facial");
        titulos.add(2,"Coco Terapia");
        titulos.add(3,"Vacunterapia");
        RecyclerViewAdapterCitas adaptador=new RecyclerViewAdapterCitas(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);
    }


}
