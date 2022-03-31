package com.softdesign.vitorfurini.service.impl;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrudBookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CrudBookServiceImpl bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.bookService = new CrudBookServiceImpl(bookRepository);
    }

    @Test
    public void createBook() {
        when(bookRepository.save(getMock())).thenReturn(getMock());

        bookService.createBook(getDtoMock());

        verify(bookRepository, times(1)).save(getMock());
    }

    @Test
    public void updateBook() {

        when(bookRepository.save(getMock())).thenReturn(getMock());

        bookService.updateBook(Optional.ofNullable(getDtoMock()), "6244d10e920cb429d33b2bc2");

        verify(bookRepository, times(1)).save(getMock());
    }

    @Test
    public void deleteBook() {

        when(bookRepository.findById("6244d10e920cb429d33b2bc2")).thenReturn(java.util.Optional.of(getMock()));

        bookService.deleteBook("6244d10e920cb429d33b2bc2");

        verify(bookRepository, times(1)).deleteById("6244d10e920cb429d33b2bc2");
    }

    @Test
    public void getIsRentedBook() {

        when(bookRepository.findById("6244d10e920cb429d33b2bc2")).thenReturn(java.util.Optional.of(getMock()));

        bookService.getRented("6244d10e920cb429d33b2bc2");

        verify(bookRepository, times(1)).findById("6244d10e920cb429d33b2bc2");
    }


    public BookDTO getDtoMock() {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setRented(false);
        bookDTO.setAuthor("Vitor Furini");
        bookDTO.setChapter("1");
        bookDTO.setName("A procura de um emprego");

        return bookDTO;
    }

    public Book getMock() {
        Book mock = new Book();

        mock.setRented(false);
        mock.setAuthor("Vitor Furini");
        mock.setChapter("1");
        mock.setName("A procura de um emprego");

        return mock;
    }


}
