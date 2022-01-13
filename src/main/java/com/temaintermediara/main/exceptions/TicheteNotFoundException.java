package com.temaintermediara.main.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicheteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TicheteNotFoundException() {
        super("Tichete does not exist!");
    }
}