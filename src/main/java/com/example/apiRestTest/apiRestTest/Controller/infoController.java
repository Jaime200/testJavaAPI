package com.example.apiRestTest.apiRestTest.Controller;


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
    public ResponseEntity<ResultItunes>  get(@RequestParam("termino")String termino) throws Exception {
        try{
            return new ResponseEntity<ResultItunes>(this._getInfoServices.infoArtists(termino), HttpStatus.OK);
        }catch (Exception e){
         throw  new Exception(e.getMessage());
        }

    }
}
