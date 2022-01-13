package com.temaintermediara.main.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class JocNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JocNotFoundException() {
        super("Joc does not exist!");
    }
}
