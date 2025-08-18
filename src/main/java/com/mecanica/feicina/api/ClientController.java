package com.mecanica.feicina.api;

import com.mecanica.feicina.api.dto.ClientRequestDTO;
import com.mecanica.feicina.api.dto.ClientResponseDTO;
import com.mecanica.feicina.api.mapper.ClientMapper;
import com.mecanica.feicina.domain.ports.in.FindAllClientsUseCase;
import com.mecanica.feicina.domain.ports.in.FindClientByIdUseCase;
import com.mecanica.feicina.domain.model.Client;
import com.mecanica.feicina.domain.ports.in.CreateClientUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private final CreateClientUseCase createClientUseCase;
    private final FindClientByIdUseCase findClientByIdUseCase;
    private final FindAllClientsUseCase findAllClientsUseCase;
    private final ClientMapper clientMapper;


    //The controller is injected with the use case
    public ClientController(CreateClientUseCase createClientUseCase, FindClientByIdUseCase findClientByIdUseCase, FindAllClientsUseCase findAllClientsUseCase, ClientMapper clientMapper) {
        this.createClientUseCase = createClientUseCase;
        this.findClientByIdUseCase = findClientByIdUseCase;
        this.findAllClientsUseCase = findAllClientsUseCase;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    public ClientResponseDTO createClient(@RequestBody ClientRequestDTO requestDTO) {
        Client clientDomain = clientMapper.toDomain(requestDTO);
        Client savedClient = createClientUseCase.createClient(clientDomain);
        return clientMapper.toResponseDTO(savedClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findClientByIdUseCase(@PathVariable UUID id) {
        try {
            return findClientByIdUseCase.searchById(id)
                    .map(clientMapper::toResponseDTO)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public List<ClientResponseDTO> listAllClients() {
        List<Client> clients = findAllClientsUseCase.findAll();

        return clients.stream()
                .map(clientMapper::toResponseDTO)
                .toList();
    }
}
