package com.mecanica.feicina.domain.ports.out; // O seu pacote pode ser um pouco diferente

import com.mecanica.feicina.domain.model.Client; // Use o seu Client aqui
import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> searchById(UUID id);
}