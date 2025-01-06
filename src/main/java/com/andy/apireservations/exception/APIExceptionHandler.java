package com.andy.apireservations.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import com.andy.apireservations.DTO.ErrorDTO;
import com.andy.apireservations.enums.APIError;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AndyException.class)
    public ResponseEntity<ErrorDTO> duplicateResource(AndyException e, WebRequest request) {
        return ResponseEntity.status(e.getStatus())
                .body(new ErrorDTO(e.getDescription(), e.getReasons()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> reasons = new ArrayList();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {

            reasons.add(String.format("%s - %s", error.getField(), error.getDefaultMessage()));
        }
        return ResponseEntity.status(APIError.VALIDATION_ERROR.getHttpStatus())
                .body(new ErrorDTO(APIError.VALIDATION_ERROR.getMessage(), reasons));
    }


    // protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
    //                                                               HttpStatusCode status, WebRequest request) {
    //     List<String> reasons = new ArrayList<>();
    //     for(FieldError error : ex.getBindingResult().getFieldErrors()) {
    //         reasons.add(String.format("%s - %s", error.getField(), error.getDefaultMessage()));
    //     }
    //     return ResponseEntity.status(APIError.VALIDATION_ERROR.getHttpStatus())
    //             .body(new ErrorDTO(APIError.VALIDATION_ERROR.getMessage(), reasons));
    // }

}
