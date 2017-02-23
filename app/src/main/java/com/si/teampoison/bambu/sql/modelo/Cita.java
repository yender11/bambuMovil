package com.si.teampoison.bambu.sql.modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by yender on 23/02/17.
 */

public class Cita {

private String codigo;
private String codigo_solicitud;
private Date fecha;
private Timestamp hora;
private String codigo_cubiculo;
private String cogido_agenda;
private String status;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_solicitud() {
        return codigo_solicitud;
    }

    public void setCodigo_solicitud(String codigo_solicitud) {
        this.codigo_solicitud = codigo_solicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public String getCodigo_cubiculo() {
        return codigo_cubiculo;
    }

    public void setCodigo_cubiculo(String codigo_cubiculo) {
        this.codigo_cubiculo = codigo_cubiculo;
    }

    public String getCogido_agenda() {
        return cogido_agenda;
    }

    public void setCogido_agenda(String cogido_agenda) {
        this.cogido_agenda = cogido_agenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



