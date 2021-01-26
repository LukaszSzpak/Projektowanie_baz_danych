package com.library.libraryDB.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PublishHouse {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "publishHouse")
    private Set<Item> itemSet;

    public PublishHouse() {
    }

    public PublishHouse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getBookSet() {
        return itemSet;
    }

    public void setBookSet(Set<Item> bookSet) {
        this.itemSet = bookSet;
    }
}
