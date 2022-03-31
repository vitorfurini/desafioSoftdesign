package com.softdesign.vitorfurini.dto;

import com.softdesign.vitorfurini.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.stream.Stream;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookDTO {

    @NotEmpty(message = "O campo name não pode ser vazio")
    private String name;
    @NotEmpty(message = "O campo author não pode ser vazio")
    private String author;
    @NotEmpty(message = "O campo chapter não pode ser vazio")
    private String chapter;
    @NotNull
    private boolean rented;
}
