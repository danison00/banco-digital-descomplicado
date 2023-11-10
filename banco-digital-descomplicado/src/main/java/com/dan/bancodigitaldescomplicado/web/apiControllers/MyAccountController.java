package com.dan.bancodigitaldescomplicado.web.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.AccountResponseDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.CreateAccountService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

@RestController
@RequestMapping("api/my-account")
public class MyAccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CreateAccountService createAccountService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<?> getDataAccount(Authentication authentication) throws Exception {

        String username = authentication.getPrincipal().toString();
        AccountResponseDto accountDto = mapper.fromAccountToAccountResponseDto(accountService.findByUsername(username));

        return ResponseEntity.ok().body(accountDto);
    }


    @DeleteMapping
    public ResponseEntity<?> delete(Authentication authentication) throws Exception {

        String username = authentication.getPrincipal().toString();
        createAccountService.deleteAccount(username);
        return ResponseEntity.ok().build();

    }

}
