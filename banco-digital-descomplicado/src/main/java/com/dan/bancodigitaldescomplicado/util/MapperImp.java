package com.dan.bancodigitaldescomplicado.util;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dan.bancodigitaldescomplicado.model.dto.AccountDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.dto.DepositDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.model.entity.Deposit;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;
import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

@Component
public class MapperImp implements Mapper {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Override
    public Account fromCreateAccountRequestToAccount(CreateAccountRequest createAcc) throws Exception {

        return new Account(createAcc.typeAccount());

    }

    @Override
    public Client fromCreateAccountRequestToCliente(CreateAccountRequest createAcc) throws Exception {
        User user = userService.findByUsername(createAcc.username()).get();
       
        return new Client(
                createAcc.cpf(),
                createAcc.name(),
                createAcc.email(),
                createAcc.telephone(),
                user);

    }

    @Override
    public Transfer fromTransactionDtoToTransaction(TransferDto transactionDto) throws Exception {

        Account accountOrigin = accountService.findByNumber(transactionDto.accountOrigin());
        Account accountDestination = accountService.findByNumber(transactionDto.accountSend());
        BigDecimal value = transactionDto.value();

        return new Transfer(accountOrigin, accountDestination, value);

    }

    public Deposit fromDepositDtoToDeposit(DepositDto depositDto) throws Exception {

        Account accountOrigin = accountService.findByNumber(depositDto.accountNumber());

        return new Deposit(accountOrigin, depositDto.value());

    }

    @Override
    public AccountDto fromAccountToAccountDto(Account account) {

        return new AccountDto(
                account.getNumber(),
                account.getBalance(),
                account.getOpeningDate(),
                account.getDeposits(),
                account.getTransactionsReceived(),
                account.getTransactionsSend());

    }

}
