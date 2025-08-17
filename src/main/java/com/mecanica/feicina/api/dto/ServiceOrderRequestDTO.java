package com.mecanica.feicina.api.dto;

import java.util.List;
import java.util.UUID;

public record ServiceOrderRequestDTO(
        UUID customerId,
        String status,
        List<ServiceDTO> services,
        List<PartDTO> parts
) {
    public record ServiceDTO(String description, Double price) {}
    public record PartDTO(String name, int quantity, Double unitPrice) {}
}