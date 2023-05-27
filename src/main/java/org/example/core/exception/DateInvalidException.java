package org.example.core.exception;

/**
 * This class use when Date is invalid.
 */
public class DateInvalidException extends Exception{

    public DateInvalidException() {
    }

    public DateInvalidException(String message) {
        super(message);
    }
}
