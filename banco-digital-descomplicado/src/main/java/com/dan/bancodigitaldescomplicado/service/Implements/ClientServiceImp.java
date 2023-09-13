package com.dan.bancodigitaldescomplicado.service.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.bancodigitaldescomplicado.model.entity.Client;
import com.dan.bancodigitaldescomplicado.repository.ClienteRepository;
import com.dan.bancodigitaldescomplicado.service.interfaces.ClientService;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Client save(Client client) {
        
        return clienteRepository.save(client);
    }


    @Override
    public void edit(Client client) throws Exception {

        findById(client.getId());
        clienteRepository.saveAndFlush(client);

    }

    @Override
    public Client findById(Long id) throws Exception {

        return clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não encontrado!"));
    }

}
