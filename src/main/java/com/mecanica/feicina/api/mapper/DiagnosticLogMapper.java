package com.mecanica.feicina.api.mapper;

import com.mecanica.feicina.api.dto.DiagnosticLogRequestDTO;
import com.mecanica.feicina.api.dto.DiagnosticLogResponseDTO;
import com.mecanica.feicina.domain.model.DiagnosticLog;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DiagnosticLogMapper {

    public DiagnosticLog toDomain(DiagnosticLogRequestDTO dto) {
        DiagnosticLog log = new DiagnosticLog();

        //log.setId(UUID.randomUUID());
        log.setLogTimestamp(LocalDateTime.now());
        log.setVehicleId(dto.vehicleId());
        log.setErrorCode(dto.errorCode());
        log.setMechanicNotes(dto.mechanicNotes());
        return log;
    }

    public DiagnosticLogResponseDTO toResponseDTO(DiagnosticLog log) {
        return new DiagnosticLogResponseDTO(
                log.getId(),
                log.getVehicleId(),
                log.getLogTimestamp(),
                log.getErrorCode(),
                log.getMechanicNotes()
        );
    }
}