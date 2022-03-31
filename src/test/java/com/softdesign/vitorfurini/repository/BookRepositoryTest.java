package com.softdesign.vitorfurini.repository;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

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
    public void getAll() {

        bookService.listAll();

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void searchProductById() {

        when(bookRepository.findById(any())).thenReturn(java.util.Optional.of(new Book()));

        bookService.findById(anyString());

        verify(bookRepository, times(1)).findById(anyString());

    }

    @Test(expected = ResponseStatusException.class)
    public void searchProductByIdWithResponseStatusException() {

        when(bookRepository.findById(anyString())).thenReturn(Optional.empty());

        bookService.findById(anyString());

    }


}
