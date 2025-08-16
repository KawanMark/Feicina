package com.mecanica.feicina.infrastructure.persistence.jpa;

import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.out.ClientRepositoryPort;
import com.mecanica.feicina.infrastructure.persistence.jpa.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.Optional;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    //Injection implementation spring Data JPA
    private final ClientRepositoryJPA clientRepositoryJPA;


    public ClientRepositoryAdapter(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    @Override
    public Client save(Client client){
        return clientRepositoryJPA.save(client);
    }

    @Override
    public Optional<Client> searchById(UUID id) {
        return clientRepositoryJPA.findById(id);
    }
}
