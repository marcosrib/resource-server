package com.br.resource_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String teste() {
        System.out.println("Teste endpoint acessado!");
        return "API funcionando!";
    }

}