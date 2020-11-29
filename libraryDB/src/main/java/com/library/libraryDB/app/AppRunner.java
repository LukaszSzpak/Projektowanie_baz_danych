package com.library.libraryDB.app;

import com.library.libraryDB.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {

        //Uncomment line below to erase DB and load sample data
        new SampleData(mongoTemplate).eraseAndAddSampleData();
    }
}
