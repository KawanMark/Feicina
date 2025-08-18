package com.mecanica.feicina.domain.ports.out;

import com.mecanica.feicina.domain.model.DiagnosticLog;

public interface DiagnosticLogRepositoryPort {
    DiagnosticLog save(DiagnosticLog diagnosticLog);
}
