package org.example.service.validation.charvalidation;

import org.example.core.exception.CharInvalidateException;

public interface CharValidation {

    void validateInput(String input) throws CharInvalidateException;
    boolean isValidInput(String input);
}
