package com.example.apiRestTest.apiRestTest.useCase;


import com.example.apiRestTest.apiRestTest.Entity.ResultItunes;
import com.example.apiRestTest.apiRestTest.Entity.Tvmaze;

import java.util.List;

public interface getInfoServices {

    ResultItunes infoArtists(String termino) throws Exception;
    void infoPersonas(String termino);
    List<Tvmaze> infoTvmaze(String termino) throws Exception;
}


