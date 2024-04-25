package com.tbtbglobal.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
    private int statusCode;
    private String message;
}
