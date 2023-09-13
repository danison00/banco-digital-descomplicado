package com.dan.bancodigitaldescomplicado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dan.bancodigitaldescomplicado.model.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.conta.number = :accountNumber")
    Optional<User> findByAccountNumber(String accountNumber);
    
}
