package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Deposit;

public interface DepositService {

    void executeDeposit(Deposit deposit) throws Exception;

    void incrementValue(Account account, BigDecimal value);

    
}
