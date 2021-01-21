package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateItemDto;
import com.library.libraryDB.entities.Item;

public interface ItemService {
    Item getItem(String id);
    Item createItem(CreateItemDto createItemDto);
    Item updateItem(String id, Item item);
}
