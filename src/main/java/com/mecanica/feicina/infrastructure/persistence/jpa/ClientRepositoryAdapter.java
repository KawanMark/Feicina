package com.mecanica.feicina.infrastructure.persistence.jpa; // Seu pacote

import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.out.ClientRepositoryPort;
import com.mecanica.feicina.infrastructure.persistence.jpa.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientRepositoryJPA clientRepositoryJPA;

    public ClientRepositoryAdapter(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    @Override
    public Client save(Client client) {
        return clientRepositoryJPA.save(client);
    }

    @Override
    public Optional<Client> searchById(UUID id) {
        return clientRepositoryJPA.searchById(id);
    }
}