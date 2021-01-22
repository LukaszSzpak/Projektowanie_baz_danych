package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;

import java.util.List;
import java.util.Set;

public interface BookService {
    Book addItem(Long id, Long itemId);
    List<Long> getItemList(Long id);
    Book getBook(Long id);
    List<Book> getBooks();
    Book createBook(CreateBookDto createBookDto);
    Book updateBook(Long id, Book book);
    boolean deleteBookWithItems(Long id);
    boolean changeAvaliable(Long id, boolean avaliable);
    List<Book> searchBook(String searchingPhrase);
}
