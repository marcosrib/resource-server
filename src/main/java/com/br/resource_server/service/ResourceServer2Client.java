package com.br.resource_server.service;

import org.springframework.web.service.annotation.GetExchange;

public interface ResourceServer2Client {

    @GetExchange(value = "/resource", accept = "application/json")
    String get();
}
