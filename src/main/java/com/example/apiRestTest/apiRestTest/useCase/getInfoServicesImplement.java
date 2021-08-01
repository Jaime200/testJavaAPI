package com.example.apiRestTest.apiRestTest.useCase;

import com.example.apiRestTest.apiRestTest.Entity.ResultItunes;
import com.example.apiRestTest.apiRestTest.Entity.Tvmaze;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Component
public class getInfoServicesImplement implements getInfoServices{
    @Override
    public ResultItunes infoArtists(String termino) throws Exception {


        final String uri = "https://itunes.apple.com/search?term={termino}";
        try {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class, termino);
            Gson gson = new Gson();
            ResultItunes arrItunesArtist =  gson.fromJson(result, ResultItunes.class);
            return arrItunesArtist;
        } catch (Exception e) {

            throw new Exception( e.getMessage(),e.getCause());
        }

    }

    @Override
    public void infoPersonas(String termino) {

    }

    @Override
    public List<Tvmaze> infoTvmaze(String termino) throws Exception {


                final String uri = "http://api.tvmaze.com/search/shows?q={termino}";
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    String result = restTemplate.getForObject(uri, String.class, termino);

                    Gson gson = new Gson();
                    java.lang.reflect.Type listType = new TypeToken<List<Tvmaze>>(){}.getType();
                    List<Tvmaze> arrTvmaze = new ArrayList<Tvmaze>();
                    arrTvmaze =  gson.fromJson(result, listType);
                    return arrTvmaze;
                } catch (Exception e) {

                    throw new Exception( e.getMessage(),e.getCause());
                }


    }
}
