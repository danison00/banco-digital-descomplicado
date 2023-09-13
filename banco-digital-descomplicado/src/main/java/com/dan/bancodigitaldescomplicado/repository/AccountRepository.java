package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.Account;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long>{

    Optional<Account> findByNumber(String number);
    
}
