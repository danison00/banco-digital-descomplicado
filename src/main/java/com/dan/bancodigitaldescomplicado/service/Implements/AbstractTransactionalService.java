package com.dan.bancodigitaldescomplicado.service.Implements;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Transactional;

import com.dan.bancodigitaldescomplicado.model.entity.Account;

public abstract class AbstractTransactionalService {

    @Transactional
    public void incrementValue(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().add(value));

    }

    @Transactional
    public void decrementValue(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().subtract(value));

    }
}
