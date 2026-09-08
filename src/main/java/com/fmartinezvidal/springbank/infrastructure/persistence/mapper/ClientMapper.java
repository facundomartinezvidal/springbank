package com.fmartinezvidal.springbank.infrastructure.persistence.mapper;

import com.fmartinezvidal.springbank.domain.model.Client;
import com.fmartinezvidal.springbank.infrastructure.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toDomain(ClientEntity entity);
    ClientEntity toEntity(Client client);
}
