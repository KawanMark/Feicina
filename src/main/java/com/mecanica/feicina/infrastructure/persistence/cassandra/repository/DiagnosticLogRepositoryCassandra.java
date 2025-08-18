package com.mecanica.feicina.infrastructure.persistence.cassandra.repository;


import com.mecanica.feicina.domain.model.DiagnosticLog;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiagnosticLogRepositoryCassandra extends CassandraRepository<DiagnosticLog, UUID> {

}
