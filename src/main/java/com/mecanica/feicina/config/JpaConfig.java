package com.mecanica.feicina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.mecanica.feicina.infrastructure.persistence.jpa.repository")
@EnableTransactionManagement
public class JpaConfig {
}