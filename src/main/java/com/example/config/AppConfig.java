package com.example.config;

import com.example.config.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//AppConfig — root application context
//This context is responsible for:
//Services,DAOs/Repositories,Database configuration,Transactions,Other business logic

@Configuration
@ComponentScan(basePackages = {
        "com.example.service",
        "com.example.dao"
})
@Import(DatabaseConfig.class)
public class AppConfig {
}