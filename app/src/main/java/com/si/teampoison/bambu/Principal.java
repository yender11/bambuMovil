package com.si.teampoison.bambu;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;


import com.si.teampoison.bambu.sql.modelo.Prueba;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RadioButton rb_sugerencia, rb_reclamo, rb_informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rb_sugerencia= (RadioButton) findViewById(R.id.id_sugerencia);
        rb_reclamo = (RadioButton) findViewById(R.id.id_reclamo);
        rb_informacion= (RadioButton) findViewById(R.id.id_informacion);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //**************pruebaaa************************

    private class HttpRequestTask extends AsyncTask<Void, Void, Prueba> {
        @Override
        protected Prueba doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Prueba prueba = restTemplate.getForObject(url, Prueba.class);
                return prueba;

            } catch (Exception e) {
                Log.e("Principal", e.getMessage(), e);
            }

            return null;
        }
            @Override
            protected void onPostExecute(Prueba prueba) {
                TextView pruebaIdText = (TextView) findViewById(R.id.id_value);
                TextView pruebaContentText = (TextView) findViewById(R.id.content_value);
                pruebaIdText.setText(prueba.getId());
                pruebaContentText.setText(prueba.getContent());
            }

      }



    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }


    //**************pruebaaa************************


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
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

        else if (id==R.id.action_notificaciones){
            Intent i = new Intent(this,Notificaciones.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_mis_citas) {
            Intent i = new Intent(this,Citas.class);
            startActivity(i);
        } else if (id == R.id.nav_mis_avances) {

            new HttpRequestTask().execute();
        }

        else if (id == R.id.nav_contactanos) {
            //DIALOGO TIPO DE CONTACTANOS
            DialogoContactanos dialog = new DialogoContactanos();
            dialog.show(getSupportFragmentManager(), "etiqueta");

        }
        else if (id == R.id.nav_cerrar_sesion) {
            DialogoCerrarSesion d= new DialogoCerrarSesion();
            d.show(getSupportFragmentManager(), "etiqueta");
        }
            else if (id== R.id.nav_noticias) {
        }

        else if (id== R.id.nav_notificaciones) {
            Intent i = new Intent(this, Notificaciones.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
