package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dan.bancodigitaldescomplicado.model.entity.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    
}
