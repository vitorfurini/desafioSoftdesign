package com.softdesign.vitorfurini.exceptions;

public class NotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Livro não encontra-se registrado na base de dados";

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
