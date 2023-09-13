package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface AccountService {

    Account save(Account account);

    void deleteById(Long id) throws Exception;

    void edit(Account account) throws Exception;

    Account findById(Long id) throws Exception;

    Account findByNumber(String number) throws Exception;

    Account update(Account account);

}
