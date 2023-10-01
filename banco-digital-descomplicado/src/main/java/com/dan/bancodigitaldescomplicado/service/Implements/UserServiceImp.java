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

        if(loadUserByUsername(user.getUsername()) != null){
            throw new RuntimeException("Usuário já existe");
        }
     
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findByAccountNumber(String accountNumber) throws Exception {
                
        return userRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new RuntimeException("Numero de conta inexistente")); 
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        return userRepository.findByUsername(username);
    }

}
