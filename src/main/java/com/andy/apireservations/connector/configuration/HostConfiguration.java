package com.andy.apireservations.connector.configuration;

import java.util.HashMap;
import java.util.Map;

public class HostConfiguration {
    private String host;

    private int port;

    // private HashMap<String, EndpointConfiguration> endpoints;

    private Map<String, EndpointConfiguration> endpoint; // ✅ importante

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public Map<String, EndpointConfiguration> getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Map<String, EndpointConfiguration> endpoint) {
        this.endpoint = endpoint;
    }
}
