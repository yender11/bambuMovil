package com.si.teampoison.bambu.servicio;

import android.support.v7.app.AppCompatActivity;

import com.j256.ormlite.dao.Dao;
import com.si.teampoison.bambu.sql.modelo.Noticia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yender on 18/02/17.
 */

public class SimuladorDeServicio extends AppCompatActivity {

public List<Noticia> Noticias()   {

        List<Noticia> noticias =new ArrayList<>();

    noticias.add(new Noticia("00123",  "MAÑANA NO TRABAJAREMOS DIA DE LAS INFOCIENCIAS", "ACTIVO","", "00023", null));
    noticias.add(new Noticia("00124",  "Nuevas masajistas a partir del lunes", "ACTIVO","", "00033", null));
    noticias.add(new Noticia("00125",  "A partir de hoy MASAJES CON FINAL FELIZ", "ACTIVO","", "00023", null));
        return noticias;
    }

}
