package com.tbtbglobal.pruebatecnica.exceptions;

import com.tbtbglobal.pruebatecnica.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> validateError(MethodArgumentNotValidException ex){

        List<ErrorDto> errorDtos = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorDto(400, fieldError.getDefaultMessage()))
                .distinct()
                .toList();
        return new ResponseEntity<>(errorDtos, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> methodArgumentTypeMismatchException(Exception e){
        ErrorDto errorDto = new ErrorDto(400,"La hora de la cita no debe estar vacia");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
