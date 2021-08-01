package com.example.apiRestTest.apiRestTest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class infoController {

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> get(){

        return null;
    };
}
