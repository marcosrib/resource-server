package com.br.resource_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.resource_server.SecurityAnnotation.CanReadApis;
import com.br.resource_server.service.ResourceServer2Client;

@RestController
public class TesteController {

    final ResourceServer2Client resourceServer2Client;

    public TesteController(ResourceServer2Client resourceServer2Client) {
        this.resourceServer2Client = resourceServer2Client;
    }

    @GetMapping("/teste")
    @CanReadApis
    public String teste() {
        try {
            var result = resourceServer2Client.get();
            System.out.println("Teste endpoint acessado!: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Erro ao acessar o endpoint: " + e.getMessage());
        }
        return "Teste endpoint acessado!";
    }

}