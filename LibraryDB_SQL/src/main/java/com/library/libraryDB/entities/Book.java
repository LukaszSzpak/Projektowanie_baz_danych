package com.library.libraryDB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String description;

    @Column
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    private Set<Item> itemList;
    
    @ManyToMany
    private Set<User> userWishList;

    public Book() {
    }

    public Book(Long id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Item> getItemList() {
        List<Item> list = new ArrayList<>(itemList);
        return list;
    }

    public void setItemList(List<Item> itemList) {
        Set<Item> set = new HashSet<Item>(itemList);
        this.itemList = set;
    }

    public void addItemToList(Item item) {
        itemList.add(item);
    }
}
