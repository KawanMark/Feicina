package com.mecanica.feicina.api.dto;

import java.util.List;
import java.util.UUID;

public record ServiceOrderResponseDTO(
        String id,
        UUID customerId,
        String status,
        List<ServiceDTO> services,
        List<PartDTO> parts,
        Double totalPrice
) {
    public record ServiceDTO(String description, Double price) {}
    public record PartDTO(String name, int quantity, Double unitPrice) {}
}