package com.dan.bancodigitaldescomplicado.service.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.repository.AccountRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;


@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account save(Account account) {

        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        findById(id);
        accountRepository.deleteById(id);
    }

    @Override
    public void edit(Account account) throws Exception {

        findById(account.getId());
        accountRepository.save(account);

    }

    @Override
    public Account findById(Long id) throws Exception {
        return accountRepository.findById(id).orElseThrow(() -> new Exception("Conta não encontrada!"));
    }

    @Override
    public Account findByNumber(String number) throws Exception {
        return accountRepository.findByNumber(number).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    @Override
    public Account update(Account account) {

        return accountRepository.saveAndFlush(account);
    }

    @Override
    public Account findByUsername(String username) throws Exception{
        
        return accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Conta para este usuário não encontrada"));
              

    }
}
