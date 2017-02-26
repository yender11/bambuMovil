package com.si.teampoison.bambu;

import android.content.Intent;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterNoticias;
import com.si.teampoison.bambu.sql.dao.NoticiaDAO;
import com.si.teampoison.bambu.sql.modelo.Noticia;
import com.si.teampoison.bambu.sql.modelo.Prueba;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.List;


public class Home extends AppCompatActivity {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        List<Noticia> noticias = new ArrayList<>();

       ////llenado las noticias-----------------------
        NoticiaDAO noticiaDao = new NoticiaDAO();
        try {
            noticias.addAll(noticiaDao.buscarNoticias());

            } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        recyclerView = (RecyclerView) findViewById(R.id.listaNoticias);
        RecyclerViewAdapterNoticias adaptador=new RecyclerViewAdapterNoticias(noticias);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Noticia> {
        @Override
        protected Noticia doInBackground(Void... params) {
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
}



