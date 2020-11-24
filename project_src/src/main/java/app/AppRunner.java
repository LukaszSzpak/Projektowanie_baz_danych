package app;

import entities.User;
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
        System.out.println("Collection Exists? " + mongoTemplate.collectionExists("user"));
        System.out.println("Collection Exists? " + mongoTemplate.collectionExists("library"));

        User newUser = new User("1", "Lukas", "Szpak", "alukasz1@interia.pl", "hash");
        mongoTemplate.save(newUser, "user");
    }
}
