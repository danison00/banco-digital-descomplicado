package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.bancodigitaldescomplicado.model.dto.TransactionDto;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    public ResponseEntity<?> sendTransaction(@RequestBody TransactionDto transactionDto){

        return null;
    }
    
}
