package com.andy.apireservations.connector.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "http-connector")
public class HttpConnectorConfiguration {

    private Map<String, HostConfiguration> hosts = new HashMap<>();

    public Map<String, HostConfiguration> getHosts() {
        return hosts;
    }

    public void setHosts(HashMap<String, HostConfiguration> hosts) {
        this.hosts = hosts;
    }

    // public Map<String, HostConfiguration> getHosts() {
    // return hosts;
    // }

    // public void setHosts(Map<String, HostConfiguration> hosts) {
    // this.hosts = hosts;
    // }

}
