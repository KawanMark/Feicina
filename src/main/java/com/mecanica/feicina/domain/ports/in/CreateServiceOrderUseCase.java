package com.mecanica.feicina.domain.ports.in;

import com.mecanica.feicina.domain.model.ServiceOrder;

public interface CreateServiceOrderUseCase {
    ServiceOrder create(ServiceOrder serviceOrder);
}
