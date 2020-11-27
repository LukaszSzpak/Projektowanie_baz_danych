package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;

import java.util.List;

public interface BookService {
    Book addItem(String id, String itemId);
    List<String> getItemList(String id);
    Book getBook(String id);
    List<Book> getBooks();
    Book createBook(CreateBookDto createBookDto);
    Book updateBook(String id, Book book);
    boolean deleteBookWithItems(String id);
    boolean changeAvaliable(String id, boolean avaliable);
    List<Book> searchBook(String searchingPhrase);
}
