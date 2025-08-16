package com.mecanica.feicina.api;

import com.mecanica.feicina.domain.ports.in.SearchClientUseCase;
import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.in.CreateClientUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private final CreateClientUseCase createClientUseCase;
    private final SearchClientUseCase searchClientUseCase;

    //The controller is injected with the use case
    public ClientController(CreateClientUseCase createClientUseCase, SearchClientUseCase searchClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.searchClientUseCase = searchClientUseCase;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return createClientUseCase.createClient(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchClientById(@PathVariable UUID id) {
        return searchClientUseCase.searchById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }
}
