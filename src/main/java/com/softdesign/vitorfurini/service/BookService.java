package com.softdesign.vitorfurini.service;

import com.softdesign.vitorfurini.model.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> listById(String id);

    Collection<Object> findByName(String name);

    Collection<Object> findByAuthor(String author);

}
