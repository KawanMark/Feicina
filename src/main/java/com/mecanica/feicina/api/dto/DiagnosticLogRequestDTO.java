package com.mecanica.feicina.api.dto;

import java.util.UUID;

public record DiagnosticLogRequestDTO(
        UUID vehicleId,
        String errorCode,
        String mechanicNotes
) {
}
