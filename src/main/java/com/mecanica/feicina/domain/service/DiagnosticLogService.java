package com.mecanica.feicina.domain.service;

import com.mecanica.feicina.domain.model.DiagnosticLog;
import com.mecanica.feicina.domain.ports.in.CreateDiagnosticLogUseCase;
import com.mecanica.feicina.domain.ports.out.DiagnosticLogRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticLogService implements CreateDiagnosticLogUseCase {
    private final DiagnosticLogRepositoryPort repositoryPort;

    public DiagnosticLogService(DiagnosticLogRepositoryPort repositoryPort){
        this.repositoryPort = repositoryPort;
    }

    @Override
    public DiagnosticLog create(DiagnosticLog diagnosticLog) {
        return repositoryPort.save(diagnosticLog);
    }
}

