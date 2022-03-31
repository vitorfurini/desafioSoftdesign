package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import com.softdesign.vitorfurini.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> listById(String id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Collection<Object> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Collection<Object> findByAuthor(String author) {
        return this.bookRepository.findByAuthor(author);
    }

}
