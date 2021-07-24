package com.impacta.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class primeiroController {
    
    // @RequestMapping (method = RequestMethod.GET)
    @GetMapping(path="/opa")
    public String opa(){
        return "opa do Spring Boot!!!";
    }


}
