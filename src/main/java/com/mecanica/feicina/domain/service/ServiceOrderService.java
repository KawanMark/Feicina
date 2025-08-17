package com.mecanica.feicina.domain.service;

import com.mecanica.feicina.domain.model.ServiceOrder;
import com.mecanica.feicina.domain.ports.in.CreateServiceOrderUseCase;
import com.mecanica.feicina.domain.ports.out.ServiceOrderRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderService implements CreateServiceOrderUseCase {

    private final ServiceOrderRepositoryPort repositoryPort;

    public ServiceOrderService(ServiceOrderRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ServiceOrder create(ServiceOrder serviceOrder) {
        double servicesPrice = serviceOrder.getServices().stream()
                .mapToDouble(ServiceOrder.Service::getPrice)
                .sum();
        double partsPrice = serviceOrder.getParts().stream()
                .mapToDouble(p -> p.getQuantity() * p.getUnitPrice())
                .sum();

        serviceOrder.setTotalPrice(servicesPrice + partsPrice);

        return repositoryPort.save(serviceOrder);
    }
}