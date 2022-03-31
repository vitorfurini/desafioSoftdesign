package com.softdesign.vitorfurini.exceptions;

public class DuplicatedItemException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Livro já encontra-se registrado na base de dados";

    public DuplicatedItemException() {
        super(DEFAULT_MESSAGE);
    }
}
