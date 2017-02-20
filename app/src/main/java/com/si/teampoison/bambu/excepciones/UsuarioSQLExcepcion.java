package com.si.teampoison.bambu.excepciones;

/**
 * Created by yender on 18/02/17.
 */

public class UsuarioSQLExcepcion extends Exception {

    public UsuarioSQLExcepcion(String detailMessage) {
        super(detailMessage);
    }

    public UsuarioSQLExcepcion(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
