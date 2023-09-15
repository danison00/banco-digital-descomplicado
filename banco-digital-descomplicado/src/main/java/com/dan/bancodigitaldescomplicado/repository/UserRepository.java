package com.dan.bancodigitaldescomplicado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dan.bancodigitaldescomplicado.model.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    @Query("SELECT a.client.user FROM Account a WHERE a.number = :accountNumber")
    Optional<User> findByAccountNumber(String accountNumber);
    
}
