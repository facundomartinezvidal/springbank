package com.fmartinezvidal.springbank.infrastructure.persistence.adapter;

import com.fmartinezvidal.springbank.domain.model.Client;
import com.fmartinezvidal.springbank.domain.repository.IClientRepository;
import com.fmartinezvidal.springbank.infrastructure.persistence.mapper.ClientMapper;
import com.fmartinezvidal.springbank.infrastructure.persistence.repository.IClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements IClientRepository {
    private final IClientJpaRepository jpaRepository;
    private final ClientMapper mapper;

    @Override
    public Client save(Client client) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(client)));
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
