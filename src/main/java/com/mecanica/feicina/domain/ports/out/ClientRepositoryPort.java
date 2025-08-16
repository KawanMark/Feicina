package com.mecanica.feicina.domain.ports.out;
import com.mecanica.feicina.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {
    Client save(Client client);

    Optional<Client>searchById(UUID id);
}
