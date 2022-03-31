package co.saimyr.bookstore.domain.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private int statusCode;
    private final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    public NotFoundException(String message) {
        super(message);
        this.statusCode = NOT_FOUND.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getNOT_FOUND() {
        return NOT_FOUND;
    }
}
