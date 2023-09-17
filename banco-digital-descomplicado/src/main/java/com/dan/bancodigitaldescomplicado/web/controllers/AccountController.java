package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.AccountResponseDto;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

@RestController
@RequestMapping("user/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<?> getDataAccount(@RequestBody String username) throws Exception {

        System.out.println(username);
        AccountResponseDto accountDto = mapper.fromAccountToAccountResponseDto(accountService.getDataAccount(username));

        return ResponseEntity.ok().body(accountDto);
    }

}
