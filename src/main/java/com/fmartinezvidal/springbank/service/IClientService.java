package com.fmartinezvidal.springbank.service;

import com.fmartinezvidal.springbank.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client findById(long id);
    List<Client> findAll();
    Client update(long id, Client client);
    void delete(long id);
}
