package com.si.teampoison.bambu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class DetallePaquete extends AppCompatActivity {

    GridView lista_avance;
    TextView et_indicador;
    Spinner sp_serv, sp_indicador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_paquete);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        et_indicador= (TextView) findViewById(R.id.edit_indicador);

        sp_serv = (Spinner) findViewById(R.id.sp_servicio);
        sp_indicador = (Spinner) findViewById(R.id.sp_indicador);
        Carga_Servicios();
        Carga_Indicadores();


        lista_avance = (GridView) findViewById(R.id.gridv_avance);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.array_avance, R.layout.style_spinner);
        lista_avance.setAdapter(adaptador);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Carga_Servicios(){
        ArrayAdapter<CharSequence> adapter_servicios = ArrayAdapter.createFromResource(this, R.array.array_servicio, R.layout.style_spinner);
        sp_serv.setAdapter(adapter_servicios);
    }
    public void Carga_Indicadores(){
        ArrayAdapter<CharSequence> adapter_servicios = ArrayAdapter.createFromResource(this, R.array.array_indicadores, R.layout.style_spinner);
        sp_indicador.setAdapter(adapter_servicios);
    }
}
