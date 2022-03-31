package co.saimyr.bookstore.domain.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
    private int statusCode;
    private final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
    public BadRequestException( String message) {
        super(message);
        this.statusCode = BAD_REQUEST.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getBAD_REQUEST() {
        return BAD_REQUEST;
    }

}
