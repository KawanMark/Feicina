package com.mecanica.feicina.domain.ports.in;

import com.mecanica.feicina.domain.model.DiagnosticLog;

public interface CreateDiagnosticLogUseCase {
    DiagnosticLog create(DiagnosticLog diagnosticLog);
}
