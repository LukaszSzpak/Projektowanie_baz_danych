package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.ext.LocaleNames_en_GB;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Book addItem(Long id, Long itemId) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            tempBook.addItemToList(itemId);
            tempBook.setAvailable(true);
            bookRepository.save(tempBook);

            return tempBook;
        }
        return null;
    }

    @Override
    public Set<Long> getItemList(Long id) {
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get().getItemList();
        return null;
    }

    @Override
    public Book getBook(Long id) {
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();

        return null;
    }

    @Override
    public Set<Book> getBooks() {
        return new HashSet<Book>(bookRepository.findAll());
    }

    @Override
    public Book createBook(CreateBookDto createBookDto) {
        Long maxId = (long) -1;
        for(Book book : bookRepository.findAll()) {
            if (book.getId() > maxId)
                maxId = book.getId();
        }

        Book tempBook = createBookDto.makeBook(String.valueOf(maxId + 1));
        bookRepository.save(tempBook);
        return tempBook;
    }

    @Override
    public Book updateBook(Long id, Book book) {
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
    public boolean deleteBookWithItems(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            for (Long itemId: tempBook.getItemList()) {
                if (itemRepository.findById(itemId).isPresent())
                    itemRepository.deleteById(itemId);
            }

            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeAvaliable(Long id, boolean avaliable) {
        if (bookRepository.findById(id).isPresent()) {
            Book tempBook = bookRepository.findById(id).get();
            tempBook.setAvailable(avaliable);

            bookRepository.save(tempBook);
            return true;
        }
        return false;
    }

    @Override
    public Set<Book> searchBook(String searchingPhrase) {
        //TODO make a searcher XD
        return null;
    }
}
