package com.dan.bancodigitaldescomplicado.util;

import com.dan.bancodigitaldescomplicado.model.dto.AccountDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;
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

    Transfer fromTransactionDtoToTransaction(TransferRequestDto transactionDto) throws Exception;

    Deposit fromDepositDtoToDeposit(DepositRequestDto depositDto) throws Exception;

    AccountDto fromAccountToAccountDto(Account account);
}