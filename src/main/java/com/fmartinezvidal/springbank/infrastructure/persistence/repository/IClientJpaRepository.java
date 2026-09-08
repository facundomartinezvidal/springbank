package com.fmartinezvidal.springbank.infrastructure.persistence.repository;

import com.fmartinezvidal.springbank.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientJpaRepository extends JpaRepository<ClientEntity, Long> {

}
