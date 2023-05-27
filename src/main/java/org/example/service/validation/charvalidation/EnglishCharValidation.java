package org.example.service.validation.charvalidation;

import org.example.core.exception.CharInvalidateException;

public class EnglishCharValidation implements CharValidation {
    @Override
    public void validateInput(String input) throws CharInvalidateException {
        if (!input.matches("[a-zA-Z]")) {
            throw new CharInvalidateException("Not valid input");
        }
    }

    @Override
    public boolean isValidInput(String input) {
        try {
            validateInput(input);
            return true;
        } catch (CharInvalidateException e) {
            return false;
        }
    }
}
