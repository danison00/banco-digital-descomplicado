package com.dan.bancodigitaldescomplicado.util;

import com.dan.bancodigitaldescomplicado.model.dto.AccountDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.dto.DepositDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.model.entity.Deposit;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

/**
 * Mapper
 */
public interface Mapper {

    Account fromCreateAccountRequestToAccount(CreateAccountRequest createAcc) throws Exception;

    Client fromCreateAccountRequestToCliente(CreateAccountRequest createAcc) throws Exception;

    Transfer fromTransactionDtoToTransaction(TransferDto transactionDto) throws Exception;

    Deposit fromDepositDtoToDeposit(DepositDto depositDto) throws Exception;

    AccountDto fromAccountToAccountDto(Account account);
}