package com.example.apiRestTest.apiRestTest.useCase;

import com.example.apiRestTest.apiRestTest.Entity.ResultItunes;
import com.example.apiRestTest.apiRestTest.Entity.Tvmaze;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.source.tree.TryTree;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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



       /* Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://itunes.apple.com/search").queryParam("term", termino);
        Response response = target.request(MediaType.TEXT_PLAIN).get();
        String strItunesArtist = response.readEntity(String.class);
        Gson gson = new Gson();
        ResultItunes arrItunesArtist =  gson.fromJson(strItunesArtist, ResultItunes.class);

        return arrItunesArtist;*/
    }

    @Override
    public void infoPersonas(String termino) {

    }

    @Override
    public List<Tvmaze> infoTvmaze(String termino) throws Exception {

            if(termino.length() >0){
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


                /*try {
                Client client = ClientBuilder.newClient();
                WebTarget target = client.target("http://api.tvmaze.com/search/shows").queryParam("q", termino);
                Response response = target.request(MediaType.TEXT_PLAIN).get();
                String strTvmaze = response.readEntity(String.class);
                Gson gson = new Gson();
                java.lang.reflect.Type listType = new TypeToken<List<Tvmaze>>()
                {
                }.getType();

                List<Tvmaze> arrTvmaze = new ArrayList<Tvmaze>();
                arrTvmaze =  gson.fromJson(strTvmaze, listType);
                //http://api.tvmaze.com/search/shows?q=girls

                return arrTvmaze;
                } catch (Exception e) {
                    return null;
                }*/
            }




        return null;
    }
}
