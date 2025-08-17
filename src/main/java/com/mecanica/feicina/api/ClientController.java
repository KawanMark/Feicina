package com.mecanica.feicina.api;

import com.mecanica.feicina.api.dto.ClientRequestDTO;
import com.mecanica.feicina.api.dto.ClientResponseDTO;
import com.mecanica.feicina.api.mapper.ClientMapper;
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
    private final ClientMapper clientMapper;

    //The controller is injected with the use case
    public ClientController(CreateClientUseCase createClientUseCase, SearchClientUseCase searchClientUseCase, ClientMapper clientMapper) {
        this.createClientUseCase = createClientUseCase;
        this.searchClientUseCase = searchClientUseCase;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    public ClientResponseDTO createClient(@RequestBody ClientRequestDTO requestDTO) {
        Client clientDomain = clientMapper.toDomain(requestDTO);
        Client savedClient = createClientUseCase.createClient(clientDomain);
        return clientMapper.toResponseDTO(savedClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> searchClientById(@PathVariable UUID id) {
        try {
            return searchClientUseCase.searchById(id)
                    .map(clientMapper::toResponseDTO)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
