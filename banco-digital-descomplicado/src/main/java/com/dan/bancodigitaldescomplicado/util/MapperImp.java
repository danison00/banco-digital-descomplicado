package com.dan.bancodigitaldescomplicado.util;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dan.bancodigitaldescomplicado.model.dto.AccountResponseDto;
import com.dan.bancodigitaldescomplicado.model.dto.CreateAccountRequest;
import com.dan.bancodigitaldescomplicado.model.dto.DepositRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.DepositResponseDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;
import com.dan.bancodigitaldescomplicado.model.dto.TransferResponseDto;
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
    public Transfer fromTransactionDtoToTransaction(TransferRequestDto transactionDto) throws Exception {

        Account accountOrigin = accountService.findByNumber(transactionDto.accountOrigin());
        Account accountDestination = accountService.findByNumber(transactionDto.accountSend());
        BigDecimal value = transactionDto.value();

        return new Transfer(accountOrigin, accountDestination, value);

    }

    public Deposit fromDepositDtoToDeposit(DepositRequestDto depositDto) throws Exception {

        Account accountOrigin = accountService.findByNumber(depositDto.accountNumber());

        return new Deposit(accountOrigin, depositDto.value());

    }


    @Override
    public AccountResponseDto fromAccountToAccountResponseDto(Account account) {

        var depositsResponseDto = new ArrayList<DepositResponseDto>();
        var transfersReceived = new ArrayList<TransferResponseDto>();
        var transfersSend = new ArrayList<TransferResponseDto>();

        account.getDeposits().stream().forEach(
                deposit -> depositsResponseDto.add(fromDepositToDepositResponseDto(deposit)));

        account.getTransferReceived().stream().forEach(
                transfer -> transfersReceived.add(fromTransferToTransferReceivedResponseDto(transfer)));

        account.getTransferSend().stream().forEach(
                transfer -> transfersSend.add(fromTransferToTransferSendResponseDto(transfer)));

        return new AccountResponseDto(
                account.getClient().getName(),
                account.getNumber(),
                account.getBalance(),
                account.getOpeningDate().toString(),
                depositsResponseDto,
                transfersReceived,
                transfersSend);

    }

    public DepositResponseDto fromDepositToDepositResponseDto(Deposit deposit) {

        return new DepositResponseDto(deposit.getAmount(), deposit.getDateAndHour());

    }

    public TransferResponseDto fromTransferToTransferReceivedResponseDto(Transfer transfer) {

        return new TransferResponseDto(
                transfer.getOrigin().getClient().getName(),
                transfer.getOrigin().getNumber(),
                transfer.getAmount(),
                transfer.getDateAndHour());

    }

    public TransferResponseDto fromTransferToTransferSendResponseDto(Transfer transfer) {

        return new TransferResponseDto(
                transfer.getDestination().getClient().getName(),
                transfer.getDestination().getNumber(),
                transfer.getAmount(),
                transfer.getDateAndHour());

    }

}
