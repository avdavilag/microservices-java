package com.andy.apireservations.connector;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.andy.apireservations.connector.configuration.EndpointConfiguration;
import com.andy.apireservations.connector.configuration.HostConfiguration;
import com.andy.apireservations.connector.configuration.HttpConnectorConfiguration;
import com.andy.apireservations.connector.response.CityDTO;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

@Component
public class CatalogConnector {

        private final String HOST = "api-catalog";

        private final String ENDPOINT = "get-city";

        private HttpConnectorConfiguration configuration;

        @Autowired
        public CatalogConnector(HttpConnectorConfiguration configuration) {
                this.configuration = configuration;
        }

        public CityDTO getCity(String code) {

                System.out.println("calling to api-catalog");

                // HostConfiguration hostConfiguration = configuration.getHosts().get(HOST);
                // EndpointConfiguration endpointConfiguration =
                // hostConfiguration.getEndpoints().get(ENDPOINT);

                HostConfiguration hostConfiguration = configuration.getHosts().get(HOST);
                if (hostConfiguration == null) {
                        throw new IllegalStateException("No se encontró configuración para el host: " + HOST);
                }

                if (hostConfiguration.getEndpoint() == null) {
                        throw new IllegalStateException(
                                        "No se encontró configuración de endpoints para el host: " + HOST);
                }

                EndpointConfiguration endpointConfiguration = hostConfiguration.getEndpoint().get(ENDPOINT);
                if (endpointConfiguration == null) {
                        throw new IllegalStateException("No se encontró el endpoint: " + ENDPOINT);
                }

                HttpClient httpClient = HttpClient.create()
                                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
                                                Math.toIntExact(endpointConfiguration.getConnectionTimeout()))
                                .doOnConnected(conn -> conn
                                                .addHandler(new ReadTimeoutHandler(
                                                                endpointConfiguration.getReadTimeout(),
                                                                TimeUnit.MILLISECONDS))
                                                .addHandler(new WriteTimeoutHandler(
                                                                endpointConfiguration.getWriteTimeout(),
                                                                TimeUnit.MILLISECONDS)));

                WebClient client = WebClient.builder()
                                .baseUrl("http://" + hostConfiguration.getHost() + ":" + hostConfiguration.getPort()
                                                + endpointConfiguration.getUrl())
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .build();

                return client.get()
                                .uri(urlEncoder -> urlEncoder.build(code))
                                .retrieve()
                                .bodyToMono(CityDTO.class)
                                .share()
                                .block();
        }

}
