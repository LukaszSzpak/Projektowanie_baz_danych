package com.library.libraryDB.app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MongoConfig {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017/library");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "library");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
                       // .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                       //         "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials",
                       //         "Content-Range")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Content-Range");
                       // .allowCredentials(true).maxAge(3600);
            }
        };
    }
}

