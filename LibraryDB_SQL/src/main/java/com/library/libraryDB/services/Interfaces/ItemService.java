package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateItemDto;
import com.library.libraryDB.entities.Item;

public interface ItemService {
    Item getItem(Long id);
    Item createItem(CreateItemDto createItemDto);
    Item updateItem(Long id, Item item);
}
