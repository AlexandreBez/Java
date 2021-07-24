package com.impacta.exerciciossb.controllers;

import com.impacta.exerciciossb.models.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping(path = "/cliente/qualquer")
    public Cliente obterCliente(){
        
        return new Cliente(28, "Lucas", "104.725.528-20");
    }
}