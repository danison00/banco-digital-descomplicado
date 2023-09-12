package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface AccountService {

    public void save(Account account);

    public void deleteById(Long id) throws Exception;

    public void edit(Account account) throws Exception;

    public Account findById(Long id) throws Exception;

}
