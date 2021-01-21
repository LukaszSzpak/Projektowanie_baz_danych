package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateItemDto;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.services.Interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItem(Long id) {
        if (itemRepository.findById(id).isPresent())
            return itemRepository.findById(id).get();
        return null;
    }

    @Override
    public Item createItem(CreateItemDto createItemDto) {
        long maxId = -1;
        for(Item item : itemRepository.findAll()) {
            if (item.getId() > maxId)
                maxId = item.getId();
        }

        Item item = createItemDto.createItemFromDto(String.valueOf(maxId + 1));
        itemRepository.save(item);

        return item;
    }

    @Override
    public Item updateItem(Long id, Item item) {
        if (itemRepository.findById(id).isPresent()) {
            Item tempItem = itemRepository.findById(id).get();
            tempItem.setCondition(item.getCondition());
            tempItem.setPublishHouse(item.getPublishHouse());
            itemRepository.save(tempItem);

            return tempItem;
        }
        return null;
    }
}
