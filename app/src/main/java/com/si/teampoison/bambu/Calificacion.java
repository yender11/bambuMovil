package com.si.teampoison.bambu;

import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Calificacion extends AppCompatActivity {

    RatingBar ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ranking= (RatingBar) findViewById(R.id.ranking_puntuacion);
        ranking.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Calificacion.this, "Seleccionaste "+rating, Toast.LENGTH_LONG);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
