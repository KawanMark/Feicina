package com.mecanica.feicina.config;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfig {

    @Bean
    public CqlSessionBuilderCustomizer datacenterCustomizer(CassandraProperties props) {
        return builder -> builder.withLocalDatacenter(props.getLocalDatacenter());
    }
}