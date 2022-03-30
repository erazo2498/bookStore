package co.saimyr.bookstore.domain.exception;

import org.springframework.http.HttpStatus;

public class RequestException extends RuntimeException{
    private int statusCode;
    private HttpStatus httpStatus;
    public RequestException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.statusCode = httpStatus.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
