package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookServiceImpl bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void searchBookById() {

        when(bookRepository.findById("6244d10e920cb429d33b2bc2")).thenReturn(Optional.of(getMock()));

        bookService.findById("6244d10e920cb429d33b2bc2");

        verify(bookRepository, times(1)).findById(getMock().getId());

    }

    @Test
    public void searchBookByName() {

        when(bookRepository.findByName("A procura de um emprego")).thenReturn(Collections.singleton(Optional.of(getMock())));

        bookService.findByName("A procura de um emprego");

        verify(bookRepository, times(1)).findByName(getMock().getName());

    }

    @Test
    public void searchBookByAuthorName() {

        when(bookRepository.findByAuthor("Vitor Furini")).thenReturn(Collections.singleton(Optional.of(getMock())));

        bookService.findByAuthor("Vitor Furini");

        verify(bookRepository, times(1)).findByAuthor("Vitor Furini");

    }


    @Test(expected = ResponseStatusException.class)
    public void searchBookByIdWithResponseStatusException() {

        when(bookService.findById(anyString())).thenReturn(Optional.empty());

        bookService.findById(anyString());

    }

    @Test(expected = ResponseStatusException.class)
    public void searchBookByNameWithResponseStatusException() {

        when(bookService.findByName(anyString())).thenReturn(Collections.singleton(Optional.empty()));

        bookService.findByName(anyString());

    }

    @Test(expected = ResponseStatusException.class)
    public void searchBookByAuthorNameWithResponseStatusException() {

        when(bookService.findByAuthor(anyString())).thenReturn(Collections.singleton(Optional.empty()));

        bookService.findByName(anyString());

    }

    public Book getMock(){
        Book book = new Book();
        book.setRented(true);
        book.setAuthor("Vitor Furini");
        book.setName("A procura de um emprego");
        book.setChapter("1");
        book.setId("6244d10e920cb429d33b2bc2");

        return book;
    }



}
