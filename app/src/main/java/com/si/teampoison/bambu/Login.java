package com.si.teampoison.bambu;


import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.si.teampoison.bambu.sql.modelo.Usuario;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Login extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //Intent intent = new Intent (v.getContext(), Principal.class);
                //startActivityForResult(intent, 0);

                new HttpRequestTask().execute();



            }


            });
    }


    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Usuario> {
        @Override
        protected Usuario doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Usuario usuario = restTemplate.getForObject(url, Usuario.class);
                return usuario;
            } catch (Exception e) {
                Log.e("Login", e.getMessage(), e);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            TextView greetingIdText = (TextView) findViewById(R.id.id_value);
            TextView greetingContentText = (TextView) findViewById(R.id.content_value);
            greetingIdText.setText(usuario.getUsuario());
            greetingContentText.setText(usuario.getContrasenna());
        }

    }






}
