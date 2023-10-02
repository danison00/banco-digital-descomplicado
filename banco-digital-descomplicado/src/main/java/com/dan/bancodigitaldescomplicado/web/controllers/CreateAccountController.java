package com.dan.bancodigitaldescomplicado.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.CreateAccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("account")
public class CreateAccountController {

    @Autowired
    private CreateAccountService createAccountService;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest createReq) throws Exception {

        Account account = createAccountService.createAccount(createReq);

        return ResponseEntity.ok().body(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws Exception {

        if (id == null)
            throw new RuntimeException("parâmetro id inválido");    
        
        accountService.deleteById(id);
        return ResponseEntity.ok().build();

        

    }

}
