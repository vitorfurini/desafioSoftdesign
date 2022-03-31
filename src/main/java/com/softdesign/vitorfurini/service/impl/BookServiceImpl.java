package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import com.softdesign.vitorfurini.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(String id) {

        var book = this.bookRepository.findById(id);

        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else
            return book;
    }

    @Override
    public Collection<Object> findByName(String name) {

        var book = this.bookRepository.findByName(name);

        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else
            return book;
    }

    @Override
    public Collection<Object> findByAuthor(String author) {
        var book = this.bookRepository.findByAuthor(author);

        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else
            return book;
    }

}
