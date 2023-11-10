package com.dan.bancodigitaldescomplicado.web.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.AccountResponseDto;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

@RestController
@RequestMapping("api/my-account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<?> getDataAccount(Authentication authentication) throws Exception {

        String username = authentication.getPrincipal().toString();

        System.out.println(username);
        AccountResponseDto accountDto = mapper.fromAccountToAccountResponseDto(accountService.findByUsername(username));

        return ResponseEntity.ok().body(accountDto);
    }

}
