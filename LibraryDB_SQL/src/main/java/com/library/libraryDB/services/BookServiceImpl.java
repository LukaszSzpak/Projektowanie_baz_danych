package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateBookDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


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
            tempBook.addItemToList(itemRepository.getOne(itemId));
            tempBook.setAvailable(true);
            bookRepository.save(tempBook);

            return tempBook;
        }
        return null;
    }

    @Override
    public List<Long> getItemList(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            List<Long> resultList = new LinkedList<>();
            for (Item item: bookRepository.findById(id).get().getItemList()) {
                resultList.add(item.getId());
            }
            return resultList;
        }
        return null;
    }

    @Override
    public Book getBook(Long id) {
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
        Long maxId = (long) -1;
        for(Book book : bookRepository.findAll()) {
            if (book.getId() > maxId)
                maxId = book.getId();
        }

        Book tempBook = createBookDto.makeBook(maxId + 1);
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
            for (Item item: tempBook.getItemList()) {
                long itemId = item.getId();
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
    public List<Book> searchBook(String searchingPhrase) {
        //TODO make a searcher XD
        return null;
    }
}
