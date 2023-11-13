package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface TransactionsService {
   
    boolean checkSufficientBalance(Account account, BigDecimal value) throws Exception;

    void incrementBalance(Account account, BigDecimal value);

    void decrementBalance(Account account, BigDecimal value);
}
