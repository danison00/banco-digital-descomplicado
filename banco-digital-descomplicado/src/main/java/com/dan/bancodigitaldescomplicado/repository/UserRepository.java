package com.dan.bancodigitaldescomplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.bancodigitaldescomplicado.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
