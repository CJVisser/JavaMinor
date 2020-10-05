package nl.cornevisser._spring_rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class AccountHolderExceptions extends RuntimeException{
    public AccountHolderExceptions() {
        new AccountHolderExceptions("Accountholder not found.");
    }

    public AccountHolderExceptions(String message) {
        super(message);
    }

    public AccountHolderExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountHolderExceptions(Throwable cause) {
        super(cause);
    }

    public AccountHolderExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
