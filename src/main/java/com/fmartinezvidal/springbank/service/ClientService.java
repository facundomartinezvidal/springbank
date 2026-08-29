package com.fmartinezvidal.springbank.service;

import com.fmartinezvidal.springbank.model.Client;
import com.fmartinezvidal.springbank.repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;

    public Client findById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }
}
