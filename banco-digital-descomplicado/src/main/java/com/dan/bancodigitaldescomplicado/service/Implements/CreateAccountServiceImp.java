package com.dan.bancodigitaldescomplicado.service.Implements;

import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.ClientService;
import com.dan.bancodigitaldescomplicado.service.interfaces.CreateAccountService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

@Service
public class CreateAccountServiceImp implements CreateAccountService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Mapper mapper;

    @Transactional
    @Override
    public Account createAccount(CreateAccountRequest request) throws Exception{

        var account = mapper.fromCreateAccountRequestToAccount(request);
        var client = mapper.fromCreateAccountRequestToCliente(request);
        client = clientService.save(client);

        account.setNumber(generateAccountNumber());
        account.setOpeningDate(LocalDate.now());
        account.setClient(client);

        return accountService.save(account);


    }


    protected String generateAccountNumber() {
    
        return RandomStringUtils.randomNumeric(4);
        
    }
}
