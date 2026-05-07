package com.br.resource_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.br.resource_server.service.ResourceServer2Client;

@Configuration
public class RestClientConfig {

        @Bean
        public RestClient.Builder restClientBuilder() {
                return RestClient.builder();
        }

        @Bean
        public ResourceServer2Client resourceServer2Client(
                        RestClient.Builder builder,
                        OAuth2AuthorizedClientManager manager,
                        ResourceServer2Properties properties) {
                var interceptor = new OAuth2ClientHttpRequestInterceptor(manager);

                interceptor.setClientRegistrationIdResolver(_ -> properties.getOauth2ClientRegistrationId());

                RestClient restClient = builder
                                .baseUrl(properties.getBaseUrl())
                                .requestInterceptor(interceptor)
                                .build();

                RestClientAdapter adapter = RestClientAdapter.create(restClient);

                HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();

                return proxyFactory.createClient(ResourceServer2Client.class);
        }
}