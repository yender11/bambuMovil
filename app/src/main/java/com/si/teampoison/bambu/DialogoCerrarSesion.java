package com.si.teampoison.bambu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by alejandra on 21/02/17.
 */

public class DialogoCerrarSesion extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder_dialogo = new AlertDialog.Builder(getActivity());
        builder_dialogo.setView(getActivity().getLayoutInflater().inflate(R.layout.cerrar_sesion, null));

        builder_dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(((Dialog)dialog).getContext(),Home.class));
            }
        });

        builder_dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


                return builder_dialogo.create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
