package com.mecanica.feicina.domain.service;


import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.in.CreateClientUseCase;
import com.mecanica.feicina.domain.ports.in.SearchClientUseCase;
import com.mecanica.feicina.domain.ports.out.ClientRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements CreateClientUseCase, SearchClientUseCase {
    private final ClientRepositoryPort clientRepositoryPort;

    //Inject the output port, not the concrete implementation
    //this is , maybe, the "D" of Solid principles.
    //Our high level service depends on an abstraction, not on a concrete implementation.

    public ClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client){
        //Business logic can be added here if needed
        //For now, we just save the client using the repository port
        return clientRepositoryPort.save(client);
    }

    @Override
    public Optional<Client> searchById(UUID id){
        return clientRepositoryPort.searchById(id);
    }
}
