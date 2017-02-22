package com.si.teampoison.bambu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    Spinner op_ref, op_ref_concreta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        op_ref_concreta = (Spinner) findViewById(R.id.sp_referencia_concreta);

        op_ref = (Spinner) findViewById(R.id.sp_referencia);
        ArrayAdapter<CharSequence> adapter_referencia = ArrayAdapter.createFromResource(this, R.array.array_referencia, R.layout.style_spinner);
        op_ref.setAdapter(adapter_referencia);

        op_ref.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    Carga_Servicios();
                }
                if (position==2){
                    Carga_Esteticista();
                }
                if (position==3){
                    Carga_Cubiculo();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "No selecciono Nada", Toast.LENGTH_LONG);

            }
        });
    }

    public void Carga_Servicios(){
        ArrayAdapter<CharSequence> adapter_servicios = ArrayAdapter.createFromResource(this, R.array.array_servicio, R.layout.style_spinner);
        op_ref_concreta.setAdapter(adapter_servicios);
    }

    public void Carga_Esteticista(){
        ArrayAdapter<CharSequence> adapter_esteticista = ArrayAdapter.createFromResource(this, R.array.array_esteticista, R.layout.style_spinner);
        op_ref_concreta.setAdapter(adapter_esteticista);
    }

    public void Carga_Cubiculo(){
        ArrayAdapter<CharSequence> adapter_cubiculo = ArrayAdapter.createFromResource(this, R.array.array_cubiculo, R.layout.style_spinner);
        op_ref_concreta.setAdapter(adapter_cubiculo);
    }
}
