package com.softdesign.vitorfurini.repository;

import com.softdesign.vitorfurini.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface BookRepository extends MongoRepository<Book, String> {

    Collection<Object> findByName(String name);

    Collection<Object> findByAuthor(String author);
}
