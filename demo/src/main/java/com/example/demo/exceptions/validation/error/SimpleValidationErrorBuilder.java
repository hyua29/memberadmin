package com.example.demo.exceptions.validation.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * Help build ValidationException
 */
public class SimpleValidationErrorBuilder implements ValidationErrorBuilder {
    public ValidationErrorMessage fromBindingErrors(Errors errors) {
        ValidationErrorMessage error = new ValidationErrorMessage("Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}