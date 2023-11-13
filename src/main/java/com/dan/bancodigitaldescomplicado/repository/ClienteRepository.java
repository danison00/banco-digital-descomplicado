package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.Client;

public interface ClienteRepository extends JpaRepository<Client, Long> {
    
}
