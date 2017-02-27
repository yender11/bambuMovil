package com.si.teampoison.bambu.excepciones;

import com.si.teampoison.bambu.sql.modelo.Cita;

/**
 * Created by yender on 27/02/17.
 */

public class CitaSQLExcepcion extends Exception{
    public CitaSQLExcepcion(String detailMessage) {
        super(detailMessage);
    }

    public CitaSQLExcepcion(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
