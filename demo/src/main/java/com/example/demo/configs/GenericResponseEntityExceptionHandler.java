package com.example.demo.configs;


import com.example.demo.exceptions.validation.error.ValidationErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @see <a href="https://blog.codeleak.pl/2013/09/request-body-validation-in-spring-mvc-3.2.html">https://blog.codeleak.pl/2013/09/request-body-validation-in-spring-mvc-3.2.html</a>
 * Handle RequestBody Validation errors for all RestControllers
 */
@ControllerAdvice(annotations = RestController.class)
public class GenericResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private ValidationErrorBuilder validationErrorBuilder;

    @Autowired
    public GenericResponseEntityExceptionHandler(ValidationErrorBuilder simpleValidationErrorBuilder) {
        this.validationErrorBuilder = simpleValidationErrorBuilder;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Object error = validationErrorBuilder.fromBindingErrors(exception.getBindingResult());
        return super.handleExceptionInternal(exception, error, headers, status, request);
    }
}