package com.cvcvcx9.AutoComplete.config;

import co.elastic.clients.transport.TransportUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import javax.net.ssl.SSLContext;

@Configuration
public class EsClientConfig extends ElasticsearchConfiguration {


    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl(false)
                .build();
    }
    private SSLContext getSSLContext() {
        SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint("ae283187bca5c5fe1b205798e52497c32c6c9b84ec9ca5b9dc11de335601fa3f");
        return sslContext;
    }
}
