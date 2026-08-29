package com.fmartinezvidal.springbank.service;

import com.fmartinezvidal.springbank.model.Client;

public interface IClientService {
    Client create(Client client);
    Client findById(long id);
}
