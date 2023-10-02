package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;
import com.dan.bancodigitaldescomplicado.service.interfaces.DepositService;
import com.dan.bancodigitaldescomplicado.service.interfaces.TransferService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private Mapper mapper;

    @PostMapping("/transfer")
    public ResponseEntity<?> executeTransfer(@RequestBody TransferRequestDto transferDto, Authentication authentication) throws Exception {

        String username = authentication.getPrincipal().toString();

        transferService.executeTransfer(mapper.fromTransactionDtoToTransaction(transferDto, username));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositRequestDto depositDto) throws Exception {

        depositService.executeDeposit(mapper.fromDepositDtoToDeposit(depositDto));

        return ResponseEntity.ok().build();
    }

}
