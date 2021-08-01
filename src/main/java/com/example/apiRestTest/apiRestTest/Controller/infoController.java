package com.example.apiRestTest.apiRestTest.Controller;

import com.example.apiRestTest.apiRestTest.Entity.RespApi;
import com.example.apiRestTest.apiRestTest.Entity.ResultItunes;
import com.example.apiRestTest.apiRestTest.useCase.getInfoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class infoController {

    private getInfoServices _getInfoServices;
    public infoController(getInfoServices _getInfoServices){
    this._getInfoServices =  _getInfoServices;
    }
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<RespApi>  get(@RequestParam("termino")String termino) throws Exception {
        try{
            RespApi respuesta = new RespApi();
            respuesta.setResultItunes(_getInfoServices.infoArtists(termino));
            respuesta.setResultTvmaze(_getInfoServices.infoTvmaze(termino));
            return new ResponseEntity<RespApi>(respuesta, HttpStatus.OK);
        }catch (Exception e){
         throw  new Exception(e.getMessage());
        }

    }
}
