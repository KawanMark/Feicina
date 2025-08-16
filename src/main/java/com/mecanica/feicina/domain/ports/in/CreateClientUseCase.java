package com.mecanica.feicina.domain.ports.in;

import com.mecanica.feicina.domain.model.Client;

public interface CreateClientUseCase {
    Client createClient(Client client);
}
