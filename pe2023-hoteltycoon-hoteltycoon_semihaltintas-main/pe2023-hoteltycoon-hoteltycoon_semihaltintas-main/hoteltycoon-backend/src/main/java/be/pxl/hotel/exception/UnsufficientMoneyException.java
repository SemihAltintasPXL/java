package be.pxl.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
public class UnsufficientMoneyException extends RuntimeException{
    public UnsufficientMoneyException(String message) {
        super(message);
    }
}
