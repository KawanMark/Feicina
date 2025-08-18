package com.mecanica.feicina.domain.ports.in;

import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.model.Client;
import java.util.List;

public interface FindAllClientsUseCase {
    List<Client> findAll();
}