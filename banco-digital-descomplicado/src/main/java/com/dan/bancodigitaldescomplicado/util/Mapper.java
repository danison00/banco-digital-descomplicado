package com.dan.bancodigitaldescomplicado.util;

import com.dan.bancodigitaldescomplicado.model.dto.AccountResponseDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.dto.AccountDataResponseDto;
import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.LoginDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.model.entity.Deposit;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;
import com.dan.bancodigitaldescomplicado.model.entity.User;

/**
 * Mapper
 */
public interface Mapper {

    Account fromCreateAccountRequestToAccount(CreateAccountRequest createAcc) throws Exception;
    AccountDataResponseDto fromAccountToAccountDataResponseDto(Account account) throws Exception;

    Client fromCreateAccountRequestToCliente(CreateAccountRequest createAcc) throws Exception;

    Transfer fromTransactionDtoToTransaction(TransferRequestDto transactionDto, String username) throws Exception;

    Deposit fromDepositDtoToDeposit(DepositRequestDto depositDto) throws Exception;

    AccountResponseDto fromAccountToAccountResponseDto(Account account);


}