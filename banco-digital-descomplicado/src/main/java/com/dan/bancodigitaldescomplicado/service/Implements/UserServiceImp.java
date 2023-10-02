package com.dan.bancodigitaldescomplicado.service.Implements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.repository.UserRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) throws Exception {

        UserDetails users = loadUserByUsername(user.getUsername());

        if (users != null)
            throw new RuntimeException("Usuário já existe");

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByAccountNumber(String accountNumber) throws Exception {

        return userRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Numero de conta inexistente"));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDetails> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @Override
    public boolean usernameAlreadyExists(String username){

        if (loadUserByUsername(username) != null)
            return true;

        return false;

    }


}
