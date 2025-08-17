package com.mecanica.feicina.domain.ports.out;

import com.mecanica.feicina.domain.model.ServiceOrder;

public interface ServiceOrderRepositoryPort {
    ServiceOrder save(ServiceOrder serviceOrder);
}
