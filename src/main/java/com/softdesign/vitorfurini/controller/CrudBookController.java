package com.softdesign.vitorfurini.controller;

import com.softdesign.vitorfurini.dto.BookDTO;
import com.softdesign.vitorfurini.model.Book;
import com.softdesign.vitorfurini.responses.Response;
import com.softdesign.vitorfurini.service.CrudBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/crud/books")
public class CrudBookController {

    @Autowired
    CrudBookService crudBookService;

    @PostMapping()
    public ResponseEntity<Response<Book>> createBook(@Valid @RequestBody BookDTO book, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Book>(errors));
        }
        return ResponseEntity.ok(new Response<Book>(this.crudBookService.createBook(book)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<Book>> updateBook(@PathVariable(name = "id") String id, @Valid @RequestBody BookDTO book, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Book>(errors));
        }

        return ResponseEntity.ok(new Response<Book>(this.crudBookService.updateBook(Optional.ofNullable(book))));
    }

    @PutMapping(path = "updateRented/{id}")
    public ResponseEntity<Response<Book>> updateBookRented(@PathVariable(name = "id") String id, @Valid @RequestBody boolean rented, BindingResult result) {

        var response = this.crudBookService.getRented(id);

        if (response.isPresent()) {

            if (response.get().isRented() && rented) {
                ObjectError error = new ObjectError("book", "O livro selecionado já está alugado");
                result.addError(error);
            } else {
                response.orElseThrow().setRented(rented);
            }
        }

        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Book>(errors));
        }
        return ResponseEntity.ok(new Response<Book>(this.crudBookService.updateBook(response)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Book>> deleteBookById(@Valid @RequestParam String id) throws Exception {
        var response = this.crudBookService.getRented(id);

        if (response.isPresent()) {

            if (response.get().isRented()) {
                throw new IllegalArgumentException("O livro não pode ser excluído pois está alugado!");
            } else {
                this.crudBookService.deleteBook(id);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
