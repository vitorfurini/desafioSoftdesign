package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.exceptions.DuplicatedItemException;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import com.softdesign.vitorfurini.service.CrudBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class CrudBookServiceImpl implements CrudBookService {

    @Autowired
    private final BookRepository bookRepository;

    public CrudBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(BookDTO book) {

        if (bookAlreadyExists(book.getName())) {
            throw new DuplicatedItemException();
        }
        var bookSave = new Book(book.getAuthor(), book.getName(), book.getChapter(), book.isRented());

        return bookRepository.save(bookSave);
    }

    @Override
    public Book updateBook(Optional<BookDTO> book, String id) {

        var bookDto = bookRepository.findById(id);

        if (bookDto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            Book bookUpdate = bookDto.get();
            bookUpdate.setAuthor(book.orElseThrow().getAuthor());
            bookUpdate.setName(book.orElseThrow().getName());
            bookUpdate.setChapter(book.orElseThrow().getChapter());
            bookUpdate.setRented(book.orElseThrow().isRented());
            return this.bookRepository.save(bookUpdate);
        }

    }

    @Override
    public Book updateRentedBook(boolean rented, String id) {
        var bookDto = bookRepository.findById(id);
        if (bookDto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            Book bookUpdate = bookDto.get();
            bookUpdate.setRented(rented);
            return this.bookRepository.save(bookUpdate);
        }
    }

    @Override
    public ResponseEntity<Object> deleteBook(String id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

    @Override
    public Optional<BookDTO> getRented(String id) {

        var book1 = this.bookRepository.findById(id);

        var book = new BookDTO();
        book.setName(book1.orElseThrow().getName());
        book.setRented(book1.orElseThrow().isRented());
        book.setChapter(book1.orElseThrow().getChapter());
        book.setAuthor(book1.orElseThrow().getAuthor());

        return Optional.of(book);
    }

    public boolean bookAlreadyExists(String document) {
        Optional<Object> book = bookRepository.findByName(document).stream().findAny();

        return book.isPresent();

    }
}
