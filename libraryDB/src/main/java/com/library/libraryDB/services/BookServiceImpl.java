package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Book addItem(String id, String itemId) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            tempBook.addItemToList(itemId);
            bookRepository.save(tempBook);

            return tempBook;
        }
        return null;
    }

    @Override
    public List<String> getItemList(String id) {
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get().getItemList();

        return null;
    }

    @Override
    public Book getBook(String id) {
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();

        return null;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(CreateBookDto createBookDto) {
        int maxId = -1;
        for(Book book : bookRepository.findAll()) {
            if (Integer.parseInt(book.getId()) > maxId)
                maxId = Integer.parseInt(book.getId());
        }

        Book tempBook = createBookDto.makeBook(String.valueOf(maxId + 1));
        bookRepository.save(tempBook);
        return tempBook;
    }

    @Override
    public Book updateBook(String id, Book book) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            tempBook.setAuthor(book.getAuthor());
            tempBook.setAvailable(book.isAvailable());
            tempBook.setDescription(book.getDescription());
            tempBook.setItemList(book.getItemList());
            tempBook.setTitle(book.getTitle());

            bookRepository.save(tempBook);
            return tempBook;
        }
        return null;
    }

    @Override
    public boolean deleteBookWithItems(String id) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            for (String itemId: tempBook.getItemList()) {
                if (itemRepository.findById(itemId).isPresent())
                    itemRepository.deleteById(itemId);
            }

            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeAvaliable(String id, boolean avaliable) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            tempBook.setAvailable(avaliable);

            bookRepository.save(tempBook);
            return true;
        }
        return false;
    }

    @Override
    public List<Book> searchBook(String searchingPhrase) {
        //TODO make a searcher
        return null;
    }
}
