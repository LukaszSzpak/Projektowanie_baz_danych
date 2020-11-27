package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBook(@PathVariable(value = "id") String id) {
        Book tempBook = bookService.getBook(id);

        if (tempBook != null)
            return new ResponseEntity<>(tempBook, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/books")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping(value = "/book")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDto createBookDto) {
        return new ResponseEntity<>(bookService.createBook(createBookDto) ,HttpStatus.OK);
    }

    @PutMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> updateBook(@RequestBody Book book,
                                           @PathVariable(value = "id") String id) {
        Book tempBook = bookService.updateBook(id, book);

        if (tempBook != null)
            return new ResponseEntity<>(tempBook, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /*
    /book/addItem?bookId={bookId}&itemId={itemId}
     */
    @GetMapping(value = "/book/addItem")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> addItemToBook(@RequestParam Map<String, String> bookAndItem) {
        Book tempBook = bookService.addItem(bookAndItem.get("bookId"), bookAndItem.get("itemId"));

        if (tempBook != null)
            return new ResponseEntity<>(tempBook, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteBook(@PathVariable(value = "id") String id) {
        if (bookService.deleteBookWithItems(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    /*
    /book/changeAv?bookId={bookId}&avaliable={true/false}
     */
    @GetMapping(value = "/book/changeAv")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> changeAvaliable(@RequestParam Map<String, String> bookAndAvaliable) {
        boolean bookAvaliable = bookAndAvaliable.get("avaliable").equals("true");

        if (bookService.changeAvaliable(bookAndAvaliable.get("bookId"), bookAvaliable))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/book/search={phrase}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> searchBook(@PathVariable(value = "phrase") String phrase) {
        return new ResponseEntity<>(bookService.searchBook(phrase), HttpStatus.OK);
    }
}
