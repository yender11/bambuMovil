package com.si.teampoison.bambu.sql.dao;

import com.j256.ormlite.dao.Dao;
import com.si.teampoison.bambu.base.ProveedorDeContexto;
import com.si.teampoison.bambu.excepciones.UsuarioSQLExcepcion;
import com.si.teampoison.bambu.sql.conexion.DBHelper;
import com.si.teampoison.bambu.sql.modelo.Usuario;

import java.sql.SQLException;

/**
 * Created by yender on 18/02/17.
 */

public class UsuarioDAO {

    public void insertar(Usuario usuario) throws UsuarioSQLExcepcion{
        Dao dao= null;
        DBHelper dbHelper= new DBHelper(ProveedorDeContexto.getContext());
        try {
            dao = dbHelper.getHelper().getUsuarioIntegerDao();
            dao.create(usuario);
        } catch (SQLException e) {
            throw new UsuarioSQLExcepcion("Hubo un error al insertar el usuario");
        }
    }

    public Usuario consultarPorId(Long id) throws UsuarioSQLExcepcion{
        Dao dao= null;
        DBHelper dbHelper= new DBHelper(ProveedorDeContexto.getContext());
        Usuario usuario= null;
        try {
            dao = dbHelper.getHelper().getUsuarioIntegerDao();
            usuario= (Usuario)dao.queryBuilder().where().eq("id", id).query();
        } catch (SQLException e) {
            throw new UsuarioSQLExcepcion("Hubo un error al buscar el usuario");
        }
        return usuario;
    }

}
