package com.si.teampoison.bambu.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by yender on 18/02/17.
 */
@DatabaseTable(tableName = "tb_rol")
public class Rol {

    @DatabaseField(id = true)
    private String codigo;

    @DatabaseField
    private String descripcion;

    @DatabaseField
    private String status;

    public Rol() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
