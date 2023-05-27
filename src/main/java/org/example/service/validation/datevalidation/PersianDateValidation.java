package org.example.service.validation.datevalidation;

import org.example.core.exception.DateInvalidException;

public class PersianDateValidation implements DateValidation {
    @Override
    public void validateDate(String input) throws DateInvalidException {
        if (!input.matches("^[1][1-4][0-9]{2}\\/((0[1-6]\\/(0[1-9]|[1-2][0-9]|3[0-1]))|(0[7-9]\\/(0[1-9]|[1-2][0-9]|30))|(1[0-1]\\/(0[1-9]|[1-2][0-9]|30))|(12\\/(0[1-9]|[1-2][0-9])))")) {
            throw new DateInvalidException("This persian date.");
        }
    }
}
