package com.mecanica.feicina.api.dto;

import java.util.UUID;

public record ClientResponseDTO(UUID id, String nome, String telefone, String cpf) {
}
