package com.example.demo.exceptions.validation.error;

import org.springframework.validation.Errors;

public interface ValidationErrorBuilder {
    Object fromBindingErrors(Errors errors);
}
