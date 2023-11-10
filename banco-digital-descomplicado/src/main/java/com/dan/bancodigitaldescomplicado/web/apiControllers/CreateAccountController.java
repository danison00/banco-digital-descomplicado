package com.dan.bancodigitaldescomplicado.web.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.CreateAccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/account")
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

    @DeleteMapping
    public ResponseEntity<?> delete(Authentication authentication) throws Exception {

        String username = authentication.getPrincipal().toString();
        createAccountService.deleteAccount(username);
        return ResponseEntity.ok().build();

        

    }

}
