package com.mecanica.feicina.domain.service; // Seu pacote

import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.in.CreateClientUseCase;
import com.mecanica.feicina.domain.ports.in.FindClientByIdUseCase;
import com.mecanica.feicina.domain.ports.out.ClientRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements CreateClientUseCase, FindClientByIdUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }

    @Override
    public Optional<Client> searchById(UUID id) {
        return clientRepositoryPort.searchById(id);
    }
}