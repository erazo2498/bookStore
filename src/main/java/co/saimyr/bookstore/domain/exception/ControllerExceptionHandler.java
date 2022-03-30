package co.saimyr.bookstore.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<RequestMessage> RequestException(RequestException requestException){
        RequestMessage message = new RequestMessage(requestException.getStatusCode(),requestException.getMessage());
        return new ResponseEntity<>(message, requestException.getHttpStatus());
    }
}
