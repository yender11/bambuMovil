package com.si.teampoison.bambu.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by yender on 18/02/17.
 */

public class ProveedorDeContexto  extends Application{

    private Object object;
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context= getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
