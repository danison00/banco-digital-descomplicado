package com.dan.bancodigitaldescomplicado.service.Implements;

import java.time.LocalDate;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Roles;
import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.ClientService;
import com.dan.bancodigitaldescomplicado.service.interfaces.CreateAccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;
import com.dan.bancodigitaldescomplicado.util.MapperImp;

@Service
public class CreateAccountServiceImp implements CreateAccountService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private MapperImp mapper;

    @Transactional
    @Override
    public Account createAccount(CreateAccountRequest request) throws Exception{

        var account = mapper.fromCreateAccountRequestToAccount(request);
        var client = mapper.fromCreateAccountRequestToCliente(request);
        var user = client.getUser();
       
        user = userService.save(user);
        client.setUser(user);
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
