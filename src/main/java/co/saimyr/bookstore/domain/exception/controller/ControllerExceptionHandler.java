package co.saimyr.bookstore.domain.exception.controller;

import co.saimyr.bookstore.domain.exception.BadRequestException;
import co.saimyr.bookstore.domain.exception.NotFoundException;
import co.saimyr.bookstore.domain.exception.RequestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<RequestMessage> badRequestException(BadRequestException badRequestException){
        RequestMessage message = new RequestMessage(badRequestException.getStatusCode(), badRequestException.getMessage());
        return new ResponseEntity<>(message, badRequestException.getBAD_REQUEST());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<RequestMessage> notFoundException(NotFoundException notFoundException){
        RequestMessage message = new RequestMessage(notFoundException.getStatusCode(), notFoundException.getMessage());
        return new ResponseEntity<>(message, notFoundException.getNOT_FOUND());
    }
}
