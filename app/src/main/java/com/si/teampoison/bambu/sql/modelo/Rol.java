package com.si.teampoison.bambu.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by yender on 18/02/17.
 */
@DatabaseTable(tableName = "tb_rol")
public class Rol {

    @DatabaseField(id = true)
    private Long id;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String descripcion;

    public Rol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
