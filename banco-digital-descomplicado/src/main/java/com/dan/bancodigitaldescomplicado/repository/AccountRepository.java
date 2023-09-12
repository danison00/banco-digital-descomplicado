package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
