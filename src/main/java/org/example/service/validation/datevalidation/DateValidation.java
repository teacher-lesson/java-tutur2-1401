package org.example.service.validation.datevalidation;

import org.example.core.exception.DateInvalidException;

public interface DateValidation {

    void validateDate(String input) throws DateInvalidException;
}
