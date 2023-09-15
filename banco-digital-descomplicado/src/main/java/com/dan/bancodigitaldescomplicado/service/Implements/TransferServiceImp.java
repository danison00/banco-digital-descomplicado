package com.dan.bancodigitaldescomplicado.service.Implements;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dan.bancodigitaldescomplicado.model.dto.TransferDto;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;
import com.dan.bancodigitaldescomplicado.repository.TransferRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.TransferService;
import com.dan.bancodigitaldescomplicado.util.MapperImp;

@Service
public class TransferServiceImp extends AbstractTransactionalService implements TransferService {

    @Autowired
    private MapperImp mapper;

    @Autowired
    private TransferRepository transferRepository;

    @Transactional
    @Override
    public void executeTransfer(TransferDto transactionDto) throws Exception {

        Transfer transaction = mapper.fromTransactionDtoToTransaction(transactionDto);
   
        checkSufficientBalance(transaction.getOrigin(), transaction.getValue());
        tranferValue(transaction);

    }

 

    @Transactional
    @Override
    public void checkSufficientBalance(Account account, BigDecimal value) throws Exception{

        if (account.getBalance().compareTo(account.getBalance()) < 0)
            throw new RuntimeException("Saldo insuficiente");

       
    }

    @Transactional
    @Override
    public void tranferValue(Transfer transaction) {

        Account origin = transaction.getOrigin();
        Account destination = transaction.getDestination();

        incrementValue(destination, transaction.getValue());
        decrementValue(origin, transaction.getValue());

        transferRepository.saveAndFlush(transaction);


    }

    @Transactional
    @Override
    public void incrementValue(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().add(value));

    }

    @Transactional
    @Override
    public void decrementValue(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().subtract(value));

    }


}


