package com.si.teampoison.bambu.servicio;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.si.teampoison.bambu.R;
import com.si.teampoison.bambu.excepciones.NoticiaSQLExcepcion;
import com.si.teampoison.bambu.sql.dao.NoticiaDAO;
import com.si.teampoison.bambu.sql.modelo.Noticia;
import com.si.teampoison.bambu.sql.modelo.Prueba;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yender on 26/02/17.
 */

public class HttpRequestNoticias extends AsyncTask<Void, Void, List<Noticia>> {

        @Override
        public List<Noticia> doInBackground(Void... params) {

                final String url = "http://192.168.0.106:8080/spa/noticias";
                RestTemplate restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                List<Noticia> noticias = new ArrayList<>();

                noticias = restTemplate.getForObject(url +"all", List.class);

                return noticias;

        }
        @Override
        protected void onPostExecute(List<Noticia> noticias) {
                NoticiaDAO  dao = new NoticiaDAO();
                /*
                for (int i=0; i<noticias.size(); i++){
                        try {
                                dao.insertar(noticias.get(i));
                        } catch (NoticiaSQLExcepcion noticiaSQLExcepcion) {
                                noticiaSQLExcepcion.printStackTrace();
                        }
                }*/
        }

    }

