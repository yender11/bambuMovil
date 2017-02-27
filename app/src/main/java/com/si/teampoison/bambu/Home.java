package com.si.teampoison.bambu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterNotificaciones;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FULL SCREEN
     //   requestWindowFeature(Window.FEATURE_NO_TITLE);
    //    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
      //                       WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //llenado las noticias-----------------------

        //setContentView(R.layout.activity_notificaciones);
        recyclerView = (RecyclerView) findViewById(R.id.listaNoticias);
        List<String> titulos = new ArrayList<>();
        titulos.add(0,"Promocion de masajes faciales");
        titulos.add(1,"Nuevos Paquetes");
        titulos.add(2,"Conoces nuetros servicios");

        RecyclerViewAdapterNotificaciones adaptador=new RecyclerViewAdapterNotificaciones(titulos);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);
// hasta aqui
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }
            else if (id==R.id.action_iniciar_sesion){
            Intent i = new Intent(this,Login.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, DetalleNoticia.class);
        startActivity(i);
    }
}



