package com.si.teampoison.bambu.excepciones;

import com.si.teampoison.bambu.sql.modelo.Noticia;

/**
 * Created by yender on 25/02/17.
 */

public class NoticiaSQLExcepcion extends Exception {

    public NoticiaSQLExcepcion(String detailMessage) {
        super(detailMessage);
    }

    public NoticiaSQLExcepcion(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
