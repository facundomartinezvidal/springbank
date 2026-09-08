package com.fmartinezvidal.springbank.domain.repository;

import com.fmartinezvidal.springbank.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
}
