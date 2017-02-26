package com.si.teampoison.bambu.sql.dao;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.si.teampoison.bambu.base.ProveedorDeContexto;
import com.si.teampoison.bambu.excepciones.NoticiaSQLExcepcion;
import com.si.teampoison.bambu.sql.conexion.DBHelper;
import com.si.teampoison.bambu.sql.modelo.Noticia;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yender on 25/02/17.
 */

public class NoticiaDAO  {

    public void insertar(Noticia noticia) throws NoticiaSQLExcepcion {
        Dao dao= null;
        DBHelper dbHelper= new DBHelper(ProveedorDeContexto.getContext());
        try {
            dao = dbHelper.getHelper().getNoticiaIntegerDao();
            dao.createOrUpdate(noticia);
        } catch (SQLException e) {
            throw new NoticiaSQLExcepcion("Hubo un error al insertar la noticia");
        }
    }

    public Noticia consultarPorId(Long id) throws NoticiaSQLExcepcion{
        Dao dao= null;
        DBHelper dbHelper= new DBHelper(ProveedorDeContexto.getContext());
        Noticia noticia= null;
        try {
            dao = dbHelper.getHelper().getNoticiaIntegerDao();
            noticia= (Noticia)dao.queryBuilder().where().eq("id", id).query();
        } catch (SQLException e) {
            throw new NoticiaSQLExcepcion("Hubo un error al buscar la noticia");
        }
        return noticia;
    }


    public List<Noticia> buscarNoticias() throws SQLException {
        Dao dao = null;
        DBHelper dbHelper= new DBHelper(ProveedorDeContexto.getContext());
        dao = dbHelper.getNoticiaIntegerDao();
        QueryBuilder queryBuilder = dao.queryBuilder();
        if(queryBuilder.query()!=null){
            return (List<Noticia>) queryBuilder.query();
        }else{
            List<Noticia> noticias = new ArrayList<>();
            return noticias;
        }

    }

    }











