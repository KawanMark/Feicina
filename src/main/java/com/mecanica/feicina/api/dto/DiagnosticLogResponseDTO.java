package com.mecanica.feicina.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record DiagnosticLogResponseDTO(
        UUID id,
        UUID vehicleId,
        LocalDateTime logTimestamp,
        String errorCode,
        String mechanicName
) {
}
