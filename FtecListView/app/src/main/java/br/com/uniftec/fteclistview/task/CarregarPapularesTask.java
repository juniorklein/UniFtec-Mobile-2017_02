package br.com.uniftec.fteclistview.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.fteclistview.model.PopularResponse;
import br.com.uniftec.fteclistview.service.MovieService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by marioklein on 26/10/17.
 */

public class CarregarPapularesTask extends AsyncTask<String, Void, PopularResponse> {

    private MovieService movieService;
    private CarregarPopularesDelegate delegate;

    public CarregarPapularesTask(CarregarPopularesDelegate delegate){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        movieService = retrofit.create(MovieService.class);
        this.delegate = delegate;
    }

    @Override
    protected PopularResponse doInBackground(String... parameters) {

        Call<PopularResponse> call = movieService.carregarPopulares(parameters[0]);

        try {
            Response<PopularResponse> response = call.execute();
            PopularResponse popularResponse = response.body();
            return popularResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(PopularResponse popularResponse) {

        if(popularResponse != null){
            delegate.sucesso(popularResponse);
        } else {
            delegate.falha("Não foi possível carregar.");
        }

    }

    public interface CarregarPopularesDelegate {

        public void sucesso(PopularResponse popularResponse);
        public void falha(String mensagem);

    }
}
