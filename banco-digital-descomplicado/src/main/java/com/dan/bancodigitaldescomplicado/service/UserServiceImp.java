package com.dan.bancodigitaldescomplicado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.bancodigitaldescomplicado.model.entity.User;
import com.dan.bancodigitaldescomplicado.repository.UserRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) throws Exception{

        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) throws Exception {
       
        if(findByUsername(user.getUsername()).isPresent()){
            throw new RuntimeException("usuario já existe");
        }
        
        return userRepository.saveAndFlush(user);
    }
    
}
