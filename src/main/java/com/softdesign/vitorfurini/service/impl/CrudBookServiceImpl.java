package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.exceptions.DuplicatedItemException;
import com.softdesign.vitorfurini.exceptions.NotFoundException;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import com.softdesign.vitorfurini.service.CrudBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudBookServiceImpl implements CrudBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(BookDTO book) {

        if (bookAlreadyExists(book.getName())) {
            throw new DuplicatedItemException();
        }
        var bookSave = new Book(book.getAuthor(), book.getName(), book.getChapter(), book.isRented());

        return bookRepository.save(bookSave);
    }

    @Override
    public Book updateBook(Optional<BookDTO> book) {

        if (bookAlreadyExists(book.orElseThrow().getName())) {
            throw new NotFoundException();
        }

        var bookUpdate = new Book(
                book.orElseThrow().getAuthor(),
                book.orElseThrow().getName(),
                book.orElseThrow().getChapter(),
                book.orElseThrow().isRented());

        return this.bookRepository.save(bookUpdate);
    }


    @Override
    public void deleteBook(String id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<BookDTO> getRented(String id) {

        var book1 = this.bookRepository.findById(id);

        var book = new BookDTO(book1.stream().sequential());

        return Optional.of(book);
    }

    public boolean bookAlreadyExists(String document) {
        Optional<Object> book = bookRepository.findByName(document).stream().findAny();

        return book.isPresent();

    }
}
