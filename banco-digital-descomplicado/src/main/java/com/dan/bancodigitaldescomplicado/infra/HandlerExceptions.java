package com.dan.bancodigitaldescomplicado.infra;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dan.bancodigitaldescomplicado.model.dto.ErrorResponse;

@RestControllerAdvice
public class HandlerExceptions {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> exception(RuntimeException e){

        ErrorResponse error = new ErrorResponse("400", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
    
    
}
