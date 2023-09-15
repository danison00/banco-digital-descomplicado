package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface TransactionsService {
   
    void checkSufficientBalance(Account account, BigDecimal value) throws Exception;

    void incrementValue(Account account, BigDecimal value);

    void decrementValue(Account account, BigDecimal value);
}
