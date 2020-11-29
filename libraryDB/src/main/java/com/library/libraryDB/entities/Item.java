package com.library.libraryDB.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class Item {
    /*
    id - string
    available - true / false
    publish_house - string [255]
    condition - string [24] {poor, good, very_good, ...]
     */

    @Id
    private String id;
    private boolean available = true;
    private String publishHouse;
    private String condition;

    public Item() {
    }

    public Item(String id, boolean available, String publishHouse, String condition) {
        this.id = id;
        this.available = available;
        this.publishHouse = publishHouse;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public String getCondition() {
        return condition;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
