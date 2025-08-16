package com.mecanica.feicina.domain.ports.in;

import com.mecanica.feicina.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface SearchClientUseCase {
    Optional<Client> searchById(UUID id);
}
