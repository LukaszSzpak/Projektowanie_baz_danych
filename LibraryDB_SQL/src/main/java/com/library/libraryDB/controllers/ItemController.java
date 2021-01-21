package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.CreateItemDto;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.services.Interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> getItem(@PathVariable(value = "id") Long id) {
        Item tempItem = itemService.getItem(id);

        if (tempItem != null)
            return new ResponseEntity<>(tempItem, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /*
        FROM FRONT-END:
        publishHouse: <String>
        condiiton: <String>

        TO FRONT-END:
        id: <String>
        avaliable: <bool>
        publishHouse: <String>
        condiiton: <String>
     */
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> createItem(@RequestBody CreateItemDto createItemDto) {
        return new ResponseEntity<>(itemService.createItem(createItemDto), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long id,
                                           @RequestBody Item item) {
        Item tempItem = itemService.updateItem(id, item);

        if (tempItem != null)
            return new ResponseEntity<>(tempItem, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
