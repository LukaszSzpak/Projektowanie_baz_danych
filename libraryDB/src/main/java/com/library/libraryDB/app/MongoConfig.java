package com.library.libraryDB.app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017/library");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "library");
    }
}