package com.dan.bancodigitaldescomplicado.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.dan.bancodigitaldescomplicado.model.entity.User;

public interface UserService  extends UserDetailsService{

    User save(User user) throws Exception;

    User findByAccountNumber(String accountNumber) throws Exception;

    boolean usernameAlreadyExists(String username);


}
