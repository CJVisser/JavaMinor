package nl.cornevisser._spring_rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankExceptions extends RuntimeException {
    public BankExceptions() {
        new BankExceptions("bankaccount not found.");
    }

    public BankExceptions(String message) {
        super(message);
    }

    public BankExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public BankExceptions(Throwable cause) {
        super(cause);
    }

    public BankExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
