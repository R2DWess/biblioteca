package br.com.wzzy.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LivroCadastradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleLivroCadastradoException(LivroCadastradoException ex) {
        return ex.getMessage();
    }
}
