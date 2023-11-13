package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface CreateAccountService {

    public Account createAccount(CreateAccountRequest request) throws Exception;

    public void deleteAccount(String username) throws Exception;

}
