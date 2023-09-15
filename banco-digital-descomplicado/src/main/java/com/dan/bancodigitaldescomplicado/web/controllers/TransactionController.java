package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.bancodigitaldescomplicado.model.dto.DepositDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferDto;
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
    public ResponseEntity<?> sendTransaction(@RequestBody TransferDto transferDto) throws Exception {

        transferService.executeTransfer(transferDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositDto depositDto) throws Exception {

        depositService.executeDeposit(depositDto);

        return ResponseEntity.ok().build();
    }
}
