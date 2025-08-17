package com.mecanica.feicina.api.mapper;

import com.mecanica.feicina.api.dto.ClientRequestDTO;
import com.mecanica.feicina.api.dto.ClientResponseDTO;
import com.mecanica.feicina.domain.model.Client;

public class ClientMapper {
    public ClientResponseDTO toResponseDTO(Client client){
        return new ClientResponseDTO(
                client.getId(),
                client.getNome(),
                client.getTelefone(),
                client.getCpf() //Verificar o CPF em client
        );
    }

    public Client toDomain(ClientRequestDTO dto){
        return new Client(
                dto.nome(),
                dto.telefone(),
                dto.cpf()
        );
    }
}
