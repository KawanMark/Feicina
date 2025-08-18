package com.mecanica.feicina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.mecanica.feicina.infrastructure.persistence.mongodb.repository")
public class MongoConfig {
}