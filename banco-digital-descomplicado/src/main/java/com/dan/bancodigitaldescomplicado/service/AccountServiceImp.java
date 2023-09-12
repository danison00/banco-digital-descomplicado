package com.dan.bancodigitaldescomplicado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.bancodigitaldescomplicado.model.entity.Account;
import com.dan.bancodigitaldescomplicado.repository.AccountRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.AccountService;

@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        
        accountRepository.save(account);
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
    



}
