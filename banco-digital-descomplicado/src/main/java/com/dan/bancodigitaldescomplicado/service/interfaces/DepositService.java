package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.dto.DepositDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface DepositService {

    void executeDeposit(DepositDto depositDto) throws Exception;

    void incrementValue(Account account, BigDecimal value);

    
}
