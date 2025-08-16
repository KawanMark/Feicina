package com.mecanica.feicina.domain.ports.out;

import com.mecanica.feicina.domain.model.Client;

public class ClienteRepositoryPort {
    // This interface will define the methods for interacting with the Client repository.
    // For example, methods like save, findById, findAll, deleteById, etc. can be defined here.

    // Example method signatures:
    // void save(Client client);
    // Optional<Client> findById(UUID id);
    // List<Client> findAll();
    // void deleteById(UUID id);

    public interface ClientRepositoryPort {
        Client save(Client client);
    }


}
