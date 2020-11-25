package com.library.libraryDB.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "book")
public class Book {
    /*
    id - string
    title - string [255]
    author - string [255]
    description - string [>255]
    available - true / false
    item_list - list with Items
     */

    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private boolean available;
    private List<Item> itemList;

    public Book() {
    }

    public Book(String id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getId() {
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

    public List<Item> getItemList() {
        return itemList;
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

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItemFromList(int position) {
        try {
            return this.itemList.get(position);
        } catch (Exception e) {
            return null;
        }

    }

    public void addItemToList(Item item) {
        this.itemList.add(item);
    }

    public boolean deleteItemFromList(Item item) {
        try {
            this.itemList.remove(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteItemFromList(int position) {
        try {
            this.itemList.remove(position);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
