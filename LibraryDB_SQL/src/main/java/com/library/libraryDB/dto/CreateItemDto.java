package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Item;

public class CreateItemDto {
    private String publishHouse;
    private String condition;

    public CreateItemDto(String publishHouse, String condition) {
        this.publishHouse = publishHouse;
        this.condition = condition;
    }

    public CreateItemDto() {
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Item createItemFromDto(String id) {
        return new Item(id, true, this.publishHouse, this.condition);
    }
}
