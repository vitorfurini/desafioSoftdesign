package com.softdesign.vitorfurini.service;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;

import java.util.Optional;

public interface CrudBookService {

    Book createBook(BookDTO book);

    Book updateBook(Optional<BookDTO> book);

    void deleteBook(String id);

    Optional<BookDTO> getRented(String id);
}
