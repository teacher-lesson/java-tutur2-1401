package org.example.core.exception;

/**
 * use this class for when input is invalid
 */
public class CharInvalidateException extends Exception{
    public CharInvalidateException() {
    }

    public CharInvalidateException(String message) {
        super(message);
    }
}
