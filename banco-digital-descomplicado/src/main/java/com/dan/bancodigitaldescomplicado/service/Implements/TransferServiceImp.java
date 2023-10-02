package com.dan.bancodigitaldescomplicado.service.Implements;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;
import com.dan.bancodigitaldescomplicado.repository.TransferRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;
import com.dan.bancodigitaldescomplicado.service.interfaces.TransferService;

@Service
public class TransferServiceImp extends AbstractTransactionalService implements TransferService {


    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountService accountService;

    @Transactional
    @Override
    public void executeTransfer(Transfer transfer) throws Exception {

        Account origin = transfer.getOrigin();
        Account destination = transfer.getDestination();

        if(origin.getNumber().equals(destination.getNumber())){
            throw new RuntimeException("não é possível realizar uma tranferência para a mesma conta");
        }

        if(transfer.isSaveDestination()) {
            origin.getFavorites().add(destination);
            accountService.update(origin);
        }

        checkSufficientBalance(transfer.getOrigin(), transfer.getAmount());
        tranferAmount(transfer);


    }

    @Transactional
    @Override
    public void checkSufficientBalance(Account account, BigDecimal value) throws Exception{

        if (account.getBalance().compareTo(account.getBalance()) < 0)
            throw new RuntimeException("Saldo insuficiente");
       
    }

    @Transactional
    @Override
    public void tranferAmount(Transfer transfer) {

        Account origin = transfer.getOrigin();
        Account destination = transfer.getDestination();

        incrementValue(destination, transfer.getAmount());
        decrementValue(origin, transfer.getAmount());

        transferRepository.saveAndFlush(transfer);
    }

    @Transactional
    @Override
    public void incrementBalance(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().add(value));

    }

    @Transactional
    @Override
    public void decrementBalance(Account account, BigDecimal value) {

        account.setBalance(account.getBalance().subtract(value));

    }

}


