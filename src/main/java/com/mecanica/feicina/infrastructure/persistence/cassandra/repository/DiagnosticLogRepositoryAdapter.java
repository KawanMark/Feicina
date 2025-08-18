package com.mecanica.feicina.infrastructure.persistence.cassandra.repository;


import com.mecanica.feicina.domain.model.DiagnosticLog;
import com.mecanica.feicina.domain.ports.out.DiagnosticLogRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticLogRepositoryAdapter implements DiagnosticLogRepositoryPort {
    private final DiagnosticLogRepositoryCassandra repositoryCassandra;

    public DiagnosticLogRepositoryAdapter(DiagnosticLogRepositoryCassandra repositoryCassandra) {
        this.repositoryCassandra = repositoryCassandra;
    }

    @Override
    public DiagnosticLog save(DiagnosticLog diagnosticLog) {
        return repositoryCassandra.save(diagnosticLog);
    }
}
