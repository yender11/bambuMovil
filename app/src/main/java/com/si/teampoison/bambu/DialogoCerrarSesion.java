package com.si.teampoison.bambu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;


/**
 * Created by alejandra on 21/02/17.
 */

public class DialogoCerrarSesion extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder_dialogo = new AlertDialog.Builder(getActivity());
        builder_dialogo.setView(getActivity().getLayoutInflater().inflate(R.layout.cerrar_sesion, null));

        builder_dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder_dialogo.setNeutralButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.runFinalization();
                System.exit(0);
            }
        });

                return builder_dialogo.create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
