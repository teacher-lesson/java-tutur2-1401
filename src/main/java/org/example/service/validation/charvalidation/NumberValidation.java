package org.example.service.validation.charvalidation;

import org.example.core.exception.CharInvalidateException;

public class NumberValidation implements CharValidation {
    @Override
    public void validateInput(String input) throws CharInvalidateException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new CharInvalidateException("Input not Number.");
            }
        }
    }

    @Override
    public boolean isValidInput(String input) {
        //TODO
        return false;
    }
}
