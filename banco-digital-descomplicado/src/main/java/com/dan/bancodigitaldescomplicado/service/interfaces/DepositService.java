package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface DepositService {

    void executeDeposit(DepositRequestDto depositDto) throws Exception;

    void incrementValue(Account account, BigDecimal value);

    
}
