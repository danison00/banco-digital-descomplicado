package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.entity.Client;

public interface ClientService {

    public void save(Client client);

    public void deleteById(Long id) throws Exception;

    public void edit(Client client) throws Exception;

    public Client findById(Long id) throws Exception;

}