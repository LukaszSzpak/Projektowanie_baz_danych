package com.library.libraryDB.app;

import com.library.libraryDB.entities.*;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SampleData {
    private final MongoTemplate mongoTemplate;

    public SampleData(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void eraseAndAddSampleData() {

        this.dropAllCollections();
        this.createAllCollections();
        this.addUsers();
        this.addEmployes();
        this.addBooks();
        this.addItems();
        try {
            this.addLoans();
        } catch (Exception ignored) {}

    }

    private void dropAllCollections() {
        for (String collection : mongoTemplate.getCollectionNames()) {
            mongoTemplate.dropCollection(collection);
        }
    }

    private void createAllCollections() {
        mongoTemplate.createCollection(User.class);
        mongoTemplate.createCollection(Employee.class);
        mongoTemplate.createCollection(Book.class);
        mongoTemplate.createCollection(Item.class);
        mongoTemplate.createCollection(Loan.class);
    }

    private void addUsers() {
        User user1 = new User(
                "1",
                "Lukasz",
                "Szpak",
                "alukasz1@interia.pl",
                "pass1");
        user1.addToWishList("2");
        mongoTemplate.save(user1);

        mongoTemplate.save(new User(
                "2",
                "Piotr",
                "Bobeł",
                "piotr_bobel@gmail.com",
                "pass2"));

        mongoTemplate.save(new User(
                "3",
                "Piotr",
                "Augustowski",
                "piotr_augustowski@gmail.com",
                "pass3"));
    }

    private void addEmployes() {
        mongoTemplate.save(new Employee(
                "1",
                "pracownik1@gmail.com",
                "Jan",
                "Kowalski",
                "librarian",
                "pass"));
        mongoTemplate.save(new Employee(
                "2",
                "root@root.pl",
                "Admin",
                "ROOT",
                "admin",
                "root"));
    }

    private void addBooks() {
        Book book1 = new Book(
                "1",
                "Wiele do stracenia",
                "Marek Marcinowski",
                "Andrew Freshet sądzi, że złapał szczęście za ogon. Pnie się po szczeblach kariery w jednym z nowojorskich banków inwestycyjnych. Nic nie wskazuje na to, że zwykły służbowy wyjazd do Sierra Leone zamieni jego życie w rozpędzony rollercoaster."
        );
        book1.addItemToList("1");
        book1.addItemToList("2");
        mongoTemplate.save(book1);

        Book book2 = new Book(
                "2",
                "Baśń o wężowym sercu albo wtóre słowo o Jakóbie Szeli",
                "Radek Rak",
                "Baśń jest próbą stworzenia na nowo mitologii Galicji. Nie jest powieścią historyczną, i choć napisana z dużym szacunkiem dla ówczesnych realiów społecznych, obyczajowych i politycznych, to zawieszona pozostaje między historią a mitem. Wyrasta z legend, w które obrosła postać chłopskiego przywódcy – tych prawdziwych i tych stworzonych przez Radka Raka."
        );
        book1.addItemToList("3");
        mongoTemplate.save(book2);

        Book book3 = new Book(
                "3",
                "Precedens",
                "Remigiusz Mróz",
                "Do Joanny Chyłki z nietypową sprawą zgłasza się jedna z najpopularniejszych polskich aktorek. Twierdzi, że za moment popełni przestępstwo, i chce, by to właśnie prawniczka z Żelaznego & McVaya ją broniła. Zanim Chyłka ma okazję zastanowić się, jak zapobiec tragedii, jest już za późno. Kobieta brutalnie morduje swoją ofiarę, a wszystko to transmituje w mediach społecznościowych."
        );
        book3.addItemToList("4");
        book3.addItemToList("5");
        book3.addItemToList("6");
        mongoTemplate.save(book3);
    }

    private void addItems() {
        mongoTemplate.save(new Item("1", true, "Anatta", "Idealny"));
        mongoTemplate.save(new Item("2", true, "Anatta", "Uszkodzony"));

        mongoTemplate.save(new Item("3", false, "Powergraph", "Bardzo dobry"));

        mongoTemplate.save(new Item("4", true, "Czwarta Strona", "Idealny"));
        mongoTemplate.save(new Item("5", true, "Czwarta Strona", "Uszkodzona"));
        mongoTemplate.save(new Item("6", false, "Czwarta Strona", "Dobry"));
    }

    private void addLoans() throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");

        mongoTemplate.save(new Loan(
                "1",
                "1",
                "pracownik1@gmail.com",
                "2",
                "3",
                sdf1.parse("2020.11.29"),
                sdf1.parse("2020.12.12")
        ));

        mongoTemplate.save(new Loan(
                "2",
                "2",
                "pracownik1@gmail.com",
                "3",
                "6",
                sdf1.parse("2020.11.30"),
                sdf1.parse("2020.12.13")
        ));
    }
}
