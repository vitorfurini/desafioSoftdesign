package com.softdesign.vitorfurini.controller;

import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.service.impl.BookServiceImpl;
import com.softdesign.vitorfurini.service.impl.CrudBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockBean
    private BookServiceImpl bookService;

    @MockBean
    @Autowired
    private CrudBookServiceImpl crudBookService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.bookController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarLivros() {

        when(bookService.listAll())
                .thenReturn(listMock());

        bookController.getAll();

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.bookController).build());
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarLivrosPorId() {

        when(bookService.findById("6244d10e920cb429d33b2bc2"))
                .thenReturn(listMock().stream().findAny());

        bookController.getBookById("6244d10e920cb429d33b2bc2");

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.bookController).build());
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarLivrosPorNome() {

        when(bookService.findByName("A procura de um emprego"))
                .thenReturn(Collections.singleton(listMock().stream().findAny()));

        bookController.getBookByName("A procura de um emprego");

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.bookController).build());
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarLivrosPorNomeDoAuthor() {

        when(bookService.findByAuthor("A procura de um emprego"))
                .thenReturn(Collections.singleton(listMock().stream().findAny()));

        bookController.getBookByAuthor("A procura de um emprego");

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.bookController).build());
    }


    public List<Book> listMock() {

        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setRented(true);
        book.setAuthor("Vitor Furini");
        book.setName("A procura de um emprego");
        book.setChapter("1");
        book.setId("6244d10e920cb429d33b2bc2");

        bookList.add(book);

        return bookList;
    }


}
