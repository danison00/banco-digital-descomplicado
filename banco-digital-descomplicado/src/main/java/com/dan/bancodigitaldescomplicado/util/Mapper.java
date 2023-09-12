package com.dan.bancodigitaldescomplicado.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

@Component
public class Mapper {

    @Autowired
    private UserService userService;

    public Account fromCreateAccountRequestToAccount(CreateAccountRequest createAcc) throws Exception {

        return new Account(createAcc.typeAccount());

    }

    public Client fromCreateAccountRequestToCliente(CreateAccountRequest createAcc) throws Exception {
        User user = userService.findByUsername(createAcc.username()).get();
        Client client = new Client(
                createAcc.cpf(),
                createAcc.name(),
                createAcc.email(),
                createAcc.telephone(),
                user);

        return client;

    }

}
