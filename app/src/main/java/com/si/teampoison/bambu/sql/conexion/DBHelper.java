package com.si.teampoison.bambu.sql.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.app.Application;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.si.teampoison.bambu.base.ProveedorDeContexto;
import com.si.teampoison.bambu.sql.modelo.Noticia;
import com.si.teampoison.bambu.sql.modelo.Rol;
import com.si.teampoison.bambu.sql.modelo.Usuario;

import java.sql.SQLException;


/**
 * Created by yender on 18/02/17.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS= "bambu.sqlite";
    private static final Integer VERSION_BASE_DE_DATOS= 1;
    private static DBHelper mDBHelper;

    //Aqui van los atributos relacionados a las tablas de base de datos que se desean gestionar
    private Dao<Rol,Integer> rolIntegerDao;
    private Dao<Usuario, Integer> usuarioIntegerDao;
    private Dao<Noticia, String> noticiaStringDao;
    private RuntimeExceptionDao<Noticia, String> prueba = null;

    public DBHelper(Context context) {
         super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource , Usuario.class);
            TableUtils.createTable(connectionSource, Rol.class);
            TableUtils.createTable(connectionSource, Noticia.class);
        } catch (SQLException e) {
            throw new RuntimeException("Ha ocurrido un error en la creacion de la base de datos");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        onCreate(database,connectionSource);
    }

    public Dao<Rol, Integer> getRolIntegerDao() throws SQLException{
        if(rolIntegerDao==null){
            rolIntegerDao= getDao(Rol.class);
        }
        return rolIntegerDao;
    }

    public Dao<Usuario, Integer> getUsuarioIntegerDao() throws SQLException{
        if(usuarioIntegerDao==null){
            usuarioIntegerDao= getDao(Usuario.class);
        }
        return usuarioIntegerDao;
    }

    public DBHelper getHelper(Context context)  {
        if (mDBHelper == null) {
            mDBHelper = OpenHelperManager.getHelper(context, DBHelper.class);
        }
        return mDBHelper;
    }

    public void closeHelper() {
        if (mDBHelper != null) {
            OpenHelperManager.releaseHelper();
            mDBHelper = null;
        }
    }

     public Dao<Noticia, String> getNoticiaStringDao()throws SQLException {

            noticiaStringDao= getDao(Noticia.class);

        return noticiaStringDao;
    }

    public RuntimeExceptionDao<Noticia, String> getRuntimeExceptionDao(){
        if(prueba==null){
            prueba = getRuntimeExceptionDao(Noticia.class);
        }
        return prueba;
    }

    @Override
    public void close(){
        super.close();
    }
}
