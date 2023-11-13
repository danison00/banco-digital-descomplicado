package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{
    
}
