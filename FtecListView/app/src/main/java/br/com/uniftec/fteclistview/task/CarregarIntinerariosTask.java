package br.com.uniftec.fteclistview.task;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.uniftec.fteclistview.service.POAService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by marioklein on 30/11/17.
 */

public class CarregarIntinerariosTask extends AsyncTask<String, Void, List<LatLng>> {

    private CarregarIntinerariosDelegate delegate;
    private POAService service;

    public CarregarIntinerariosTask(CarregarIntinerariosDelegate delegate){

        this.delegate = delegate;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.poatransporte.com.br")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.service = retrofit.create(POAService.class);
    }


    @Override
    protected List<LatLng> doInBackground(String... params) {

        Call<JsonNode> chamada = service.carregarIntinerarios("il", params[0]);

        try {
            JsonNode response = chamada.execute().body();
            Iterator<Map.Entry<String, JsonNode>> propriedades = response.fields();

            List<LatLng> coordenadas = new ArrayList<>();

            while (propriedades.hasNext()){
                Map.Entry<String, JsonNode> propriedade = propriedades.next();

                try {
                    Integer chave = Integer.parseInt(propriedade.getKey());
                    JsonNode valor = propriedade.getValue();

                    double latitude = valor.get("lat").asDouble();
                    double longitude = valor.get("lng").asDouble();

                    LatLng coordenada = new LatLng(latitude, longitude);

                    coordenadas.add(coordenada);

                } catch (NumberFormatException e){
                    continue;
                }
            }

            return coordenadas;

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<LatLng> coordenadas) {

        if(coordenadas != null){
            delegate.sucesso(coordenadas);
        } else {
            delegate.falha("Deu p...");
        }

    }

    public interface CarregarIntinerariosDelegate {

        public void sucesso(List<LatLng>coordenadas);
        public void falha(String mensagem);
    }
}
