package com.si.teampoison.bambu.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by yender on 18/02/17.
 */
@DatabaseTable(tableName = "tb_usuario")
public class Usuario {


    @DatabaseField(id = true)
    private String usuario;

    @DatabaseField
    private String contrasenna;

    @DatabaseField( foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Rol rol;

    @DatabaseField
    private String status;


    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
