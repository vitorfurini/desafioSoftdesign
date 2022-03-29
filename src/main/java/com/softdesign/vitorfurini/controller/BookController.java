package com.softdesign.vitorfurini.controller;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/rest/books")
    public BookDTO[] getBooks(@RequestParam(value = "value", required = false) String value) {

        return null;

    }

    @GetMapping("/rest/book/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return this.modelMapper.map(this.bookService.getBookById(id), BookDTO.class);
    }

    @GetMapping("/rest/book")
    public Book getBookByIsbn(@RequestParam String isbn) {
        return null;
    }

    @PostMapping("/rest/book")
    public Book createBook(@RequestBody Book book) {
        return null;
    }

    @PutMapping("/rest/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/rest/book/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        return null;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class BookNotFoundException extends RuntimeException {
    }
}
