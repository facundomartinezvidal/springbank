package com.fmartinezvidal.springbank.application.service;

import com.fmartinezvidal.springbank.domain.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client findById(long id);
    List<Client> findAll();
    Client update(long id, Client client);
    void delete(long id);
}
