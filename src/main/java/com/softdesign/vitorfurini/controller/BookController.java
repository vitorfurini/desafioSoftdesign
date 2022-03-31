package com.softdesign.vitorfurini.controller;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.responses.Response;
import com.softdesign.vitorfurini.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<Response<List<Book>>> getAll() {
        return ResponseEntity.ok(new Response<List<Book>>(this.bookService.listAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable(name = "id") String id) {
        var response = bookService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findByname/{name}")
    public ResponseEntity<Object> getBookByName(@PathVariable(name = "name") String name) {
        var response = bookService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findByAuthor/{authorName}")
    public ResponseEntity<Object> getBookByAuthor(@PathVariable(name = "authorName") String authorName) {
        var response = bookService.findByAuthor(authorName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
