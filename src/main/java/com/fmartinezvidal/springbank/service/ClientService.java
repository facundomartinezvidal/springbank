package com.fmartinezvidal.springbank.service;

import com.fmartinezvidal.springbank.model.Client;
import com.fmartinezvidal.springbank.repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Client update(long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);

        if (existingClient != null) {
            existingClient.setFirstName(client.getFirstName());
            existingClient.setLastName(client.getLastName());
            existingClient.setEmail(client.getEmail());
            existingClient.setPhone(client.getPhone());
            existingClient.setPassword(client.getPassword());
        return clientRepository.save(existingClient);
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }

}
