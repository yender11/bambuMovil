package com.si.teampoison.bambu.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by yender on 23/02/17.
 */

@DatabaseTable(tableName = "tb_noticia")
public class Noticia {

    @DatabaseField(id = true)
    private String codigo;

    @DatabaseField
    private String descripcion;

    @DatabaseField
    private String status;

    @DatabaseField
    private String imagen;

    @DatabaseField
    private String codigo_sistema;
    @DatabaseField
    private String fecha;


    public Noticia() {
    }

    public Noticia(String codigo, String descripcion, String status, String imagen, String codigo_sistema, String fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.status = status;
        this.imagen = imagen;
        this.codigo_sistema = codigo_sistema;
        this.fecha = fecha;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCodigo_sistema() {
        return codigo_sistema;
    }

    public void setCodigo_sistema(String codigo_sistema) {
        this.codigo_sistema = codigo_sistema;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

