package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
