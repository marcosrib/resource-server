package com.br.resource_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "resource-server-2")
public class ResourceServer2Properties {
    
    private String baseUrl;
    private String oauth2ClientRegistrationId;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getOauth2ClientRegistrationId() {
        return oauth2ClientRegistrationId;
    }

    public void setOauth2ClientRegistrationId(String oauth2ClientRegistrationId) {
        this.oauth2ClientRegistrationId = oauth2ClientRegistrationId;
    }   
}
