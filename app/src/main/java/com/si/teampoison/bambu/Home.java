package com.si.teampoison.bambu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.os.AsyncTask;
import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterNoticias;
import com.si.teampoison.bambu.sql.conexion.DBHelper;
import com.si.teampoison.bambu.sql.modelo.Noticia;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;


import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class Home extends AppCompatActivity   {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;
    private DBHelper dbHelper;
    private List<Noticia> noticias;
    private RuntimeExceptionDao<Noticia, String> dao_noticias = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Noticia> noticias = dao_noticias.queryForAll();
        recyclerView = (RecyclerView) findViewById(R.id.listaNoticias);
        RecyclerViewAdapterNoticias adaptador=new RecyclerViewAdapterNoticias(noticias);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);

    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }


    public void  guardarNoticias(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        dao_noticias = dbHelper.getRuntimeExceptionNoticiasDao();

        for (int i=0; i<getNoticias().size(); i++){
               dao_noticias.createIfNotExists(noticias.get(i));
             }
    }


 private class ServiciosNoticias extends AsyncTask<Void, Void, Noticia[]> {

        @Override
        protected  Noticia[] doInBackground(Void... params) { try {
            final String url = "";

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Noticia[]> responseEntity = restTemplate.getForEntity(url, Noticia[].class);
            Noticia[] noticias = responseEntity.getBody();


            return noticias;

        } catch (Exception e) {
            Log.e("no pudo traer", e.getMessage(), e);
        }

            return null;
        }

        @Override
        public void onPostExecute(Noticia[] noticias) {

            List<Noticia> listadoNoticias  = Arrays.asList(noticias);
            Home h = new Home();
            h.setNoticias(listadoNoticias);
            h.guardarNoticias(getApplication());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new ServiciosNoticias().execute();

          }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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



