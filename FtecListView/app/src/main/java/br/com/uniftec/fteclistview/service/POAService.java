package br.com.uniftec.fteclistview.service;

import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by marioklein on 30/11/17.
 */

public interface POAService {


    @GET("/php/facades/process.php")
    public Call<JsonNode> carregarIntinerarios(@Query("a") String a, @Query("p") String p);

}
