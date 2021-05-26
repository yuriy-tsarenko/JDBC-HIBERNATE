package com.example.demo.proxy;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.UriBuilder;

@Component
public class ProxyFactory {

    public Proxy getProxy(final String baseUrl) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        cm.setMaxTotal(10);
        cm.setDefaultMaxPerRoute(3);

        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
        ResteasyClientBuilder builder = new ResteasyClientBuilder();

        ResteasyClient client = builder.httpEngine(engine).build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(baseUrl));
        return target.proxy(Proxy.class);
    }
}
