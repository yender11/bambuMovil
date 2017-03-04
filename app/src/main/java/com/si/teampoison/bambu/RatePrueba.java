package com.si.teampoison.bambu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.AsyncTask;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.teampoison.bambu.sql.conexion.DBHelper;
import com.si.teampoison.bambu.sql.modelo.Rates;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yender on 03/03/17.
 */

public class RatePrueba extends AppCompatActivity {

    private List<Rates> rates;
    private DBHelper dbHelper;
    private RuntimeExceptionDao<Rates, String> dao_rates = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }


    public void  guardarRates(Context mcontext){
        dbHelper = (DBHelper) OpenHelperManager.getHelper(mcontext, DBHelper.class);
        dao_rates = dbHelper.getRuntimeExceptionRatesDao();
        Rates rate = new Rates();
        rate = this.getRates().get(2);
        dao_rates.createIfNotExists(rate);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new ServicioRates().execute();

    }
    private class ServicioRates extends AsyncTask<Void, Void, Rates[]> {

        @Override
        protected Rates[] doInBackground(Void... params) {

            try {
                final String url = "https://bitpay.com/api/rates";

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity <Rates[]> responseEntity = restTemplate.getForEntity(url, Rates[].class);
                Rates[] rates = responseEntity.getBody();
                //MediaType  mediaType =responseEntity.getHeaders().getContentType();
                //HttpStatus statusCode = responseEntity.getStatusCode();

                return rates;

            } catch (Exception e) {
                Log.e("no pudo traer", e.getMessage(), e);
            }

            return null;
        }

       @Override
        public void onPostExecute(Rates[] rates) {

            List<Rates> listado  = Arrays.asList(rates);
            RatePrueba rp = new RatePrueba();
            rp.setRates(listado);
            rp.guardarRates(getApplication());

           //List<Rates> listad = dao_rates.queryForAll();

           //Log.i("Objeto 1", listad.);

       }
    }

}
