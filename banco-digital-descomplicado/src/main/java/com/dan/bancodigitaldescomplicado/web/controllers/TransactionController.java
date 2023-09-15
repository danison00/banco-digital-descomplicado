package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;
import com.dan.bancodigitaldescomplicado.service.interfaces.DepositService;
import com.dan.bancodigitaldescomplicado.service.interfaces.TransferService;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private DepositService depositService;

    @PostMapping("/transfer")
    public ResponseEntity<?> sendTransaction(@RequestBody TransferRequestDto transferDto) throws Exception {

        transferService.executeTransfer(transferDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositRequestDto depositDto) throws Exception {

        depositService.executeDeposit(depositDto);

        return ResponseEntity.ok().build();
    }
}
