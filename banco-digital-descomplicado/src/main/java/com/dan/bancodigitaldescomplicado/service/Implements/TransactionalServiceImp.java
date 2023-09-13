package com.dan.bancodigitaldescomplicado.service.Implements;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dan.bancodigitaldescomplicado.model.dto.TransactionDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Transaction;
import com.dan.bancodigitaldescomplicado.repository.AccountRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.TransactionService;
import com.dan.bancodigitaldescomplicado.util.Mapper;

public class TransactionalServiceImp implements TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private Mapper mapper;

    @Transactional
    @Override
    public void execute(TransactionDto transactionDto) throws Exception {

        Transaction transaction = mapper.fromTransactionDtoToTransaction(transactionDto);
        Account origin = transaction.getOrigin();
        Account destination = transaction.getDestination();
        BigDecimal value = transaction.getValue();
        transaction.setDateAndHour(LocalDateTime.now().toString());

        if (origin.getBalance().compareTo(value) < 0)  throw new RuntimeException("Saldo insuficiente");
            
        origin.setBalance(origin.getBalance().subtract(value));
        accountService.update(origin);

        destination.setBalance(destination.getBalance().add(value));
        accountService.update(destination);

    }


}
