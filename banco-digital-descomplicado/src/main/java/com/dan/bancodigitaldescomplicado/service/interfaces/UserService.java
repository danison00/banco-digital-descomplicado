package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.util.Optional;

import com.dan.bancodigitaldescomplicado.model.entity.User;

public interface UserService {

    Optional<User> findByUsername(String username) throws Exception;

    User save(User user) throws Exception;

    User findByAccountNumber(String accountNumber) throws Exception;

}
