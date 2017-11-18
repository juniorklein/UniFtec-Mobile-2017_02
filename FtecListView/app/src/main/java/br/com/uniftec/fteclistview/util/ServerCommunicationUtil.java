package br.com.uniftec.fteclistview.util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by marioklein on 16/11/17.
 */

public class ServerCommunicationUtil {

    private static ServerCommunicationUtil instance;
    private Retrofit retrofit;

    private ServerCommunicationUtil(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.207.42.228:4040/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        this.retrofit = retrofit;
    }

    public static ServerCommunicationUtil getInstance(){

        if(instance == null){
            instance = new ServerCommunicationUtil();
        }

        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
