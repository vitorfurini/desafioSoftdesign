package com.softdesign.vitorfurini.controller;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.service.impl.BookServiceImpl;
import com.softdesign.vitorfurini.service.impl.CrudBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest
public class CrudBookControllerTest {

    @Autowired
    private CrudBookController crudBookController;

    @MockBean
    private BookServiceImpl bookService;

    @MockBean
    private CrudBookServiceImpl crudBookService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.crudBookService);
    }

    @Test
    public void deveRetornarSucesso_QuandoSalvarUmLivro() {

        when(crudBookService.createBook(getDtoMock()))
                .thenReturn(mock());

        crudBookService.createBook(getDtoMock());

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.crudBookController).build());
    }

    @Test
    public void deveRetornarSucesso_QuandoAtualizarUmLivro() {

        when(crudBookService.updateBook(Optional.ofNullable(getDtoMock()), "6244d10e920cb429d33b2bc2"))
                .thenReturn(mock());

        crudBookService.createBook(getDtoMock());

        given().mockMvc(MockMvcBuilders.standaloneSetup(crudBookController).build());
    }

    @Test
    public void deveRetornarSucesso_QuandoDeletarUmLivro() {

        when(crudBookService.deleteBook("6244d10e920cb429d33b2bc2"))
                .thenReturn(ResponseEntity.accepted().body(mock()));

        crudBookService.createBook(getDtoMock());

        given().mockMvc(MockMvcBuilders.standaloneSetup(this.crudBookController).build());
    }

    public Book mock() {

        Book book = new Book();
        book.setRented(true);
        book.setAuthor("Vitor Furini");
        book.setName("A procura de um emprego");
        book.setChapter("1");
        book.setId("6244d10e920cb429d33b2bc2");

        return book;
    }

    public BookDTO getDtoMock() {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setRented(false);
        bookDTO.setAuthor("Vitor Furini");
        bookDTO.setChapter("1");
        bookDTO.setName("A procura de um emprego");

        return bookDTO;
    }


}
