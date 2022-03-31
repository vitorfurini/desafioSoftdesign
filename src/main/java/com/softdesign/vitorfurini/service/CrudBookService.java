package com.softdesign.vitorfurini.service;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CrudBookService {

    Book createBook(BookDTO book);

    Book updateBook(Optional<BookDTO> book, String id);

    Book updateRentedBook(boolean rented, String id);

    ResponseEntity<Object> deleteBook(String id);

    Optional<BookDTO> getRented(String id);
}
