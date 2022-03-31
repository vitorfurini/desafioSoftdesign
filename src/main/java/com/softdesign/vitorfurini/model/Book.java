package com.softdesign.vitorfurini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

    @Id
    private String id;
    @NotEmpty(message = "O campo name não pode ser vazio")
    private String name;
    @NotEmpty(message = "O campo author não pode ser vazio")
    private String author;
    @NotEmpty(message = "O campo chapter não pode ser vazio")
    private String chapter;
    @NotNull
    private boolean rented;

    public Book(String author, String name, String chapter, boolean rented) {
        this.author = author;
        this.name = name;
        this.chapter = chapter;
        this.rented = rented;
    }
}
