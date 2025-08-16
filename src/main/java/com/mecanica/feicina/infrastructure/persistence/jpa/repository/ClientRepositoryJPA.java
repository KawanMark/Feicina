package com.mecanica.feicina.infrastructure.persistence.jpa.repository;

import com.mecanica.feicina.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepositoryJPA extends JpaRepository<Client, UUID> {

}
