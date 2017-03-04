package com.si.teampoison.bambu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.AsyncTask;
import com.si.teampoison.bambu.adaptador.RecyclerViewAdapterNoticias;
import com.si.teampoison.bambu.sql.conexion.DBHelper;
import com.si.teampoison.bambu.sql.modelo.Noticia;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.List;


public class Home extends AppCompatActivity   {

    private RecyclerView.LayoutManager manager;
    private RecyclerView recyclerView;
    private DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RuntimeExceptionDao<Noticia, String> dao;
        dbHelper = (DBHelper) OpenHelperManager.getHelper(this, DBHelper.class);
        dao = dbHelper.getRuntimeExceptionDao();


        List<Noticia> noticias = dao.queryForAll();
        recyclerView = (RecyclerView) findViewById(R.id.listaNoticias);
        RecyclerViewAdapterNoticias adaptador=new RecyclerViewAdapterNoticias(noticias);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);
    }


private class HttpRequestNoticias extends AsyncTask<Void, Void, List<Noticia>> {

    @Override
    public List<Noticia> doInBackground(Void... params) {

        final String url = "http://172.19.25.31:8080/noticias";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        List<Noticia> noticias = new ArrayList<>();

//        noticias = restTemplate.postForEntity(u )

        return noticias;

    }



    @Override
    public void onPostExecute(List<Noticia> noticias) {


       // for (int i=0; i<noticias.size(); i++){
         //   dao.create(noticias.get(i));
       // }
    }
}




    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestNoticias().execute();

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



