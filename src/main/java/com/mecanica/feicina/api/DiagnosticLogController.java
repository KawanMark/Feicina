package com.mecanica.feicina.api;

import com.mecanica.feicina.api.dto.DiagnosticLogRequestDTO;
import com.mecanica.feicina.api.dto.DiagnosticLogResponseDTO;
import com.mecanica.feicina.api.mapper.DiagnosticLogMapper;
import com.mecanica.feicina.domain.model.DiagnosticLog;
import com.mecanica.feicina.domain.ports.in.CreateDiagnosticLogUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnostic-logs")
public class DiagnosticLogController {

    private final CreateDiagnosticLogUseCase useCase;
    private final DiagnosticLogMapper mapper;

    public DiagnosticLogController(CreateDiagnosticLogUseCase useCase, DiagnosticLogMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public DiagnosticLogResponseDTO create(@RequestBody DiagnosticLogRequestDTO requestDTO) {
        // DTO -> Domain -> UseCase -> Domain -> DTO
        DiagnosticLog domainObj = mapper.toDomain(requestDTO);
        DiagnosticLog savedDomainObj = useCase.create(domainObj);
        return mapper.toResponseDTO(savedDomainObj);
    }
}