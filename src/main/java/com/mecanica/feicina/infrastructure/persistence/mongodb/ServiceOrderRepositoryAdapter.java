package com.mecanica.feicina.infrastructure.persistence.mongodb;

import com.mecanica.feicina.domain.model.ServiceOrder;
import com.mecanica.feicina.domain.ports.out.ServiceOrderRepositoryPort;
import com.mecanica.feicina.infrastructure.persistence.mongodb.repository.ServiceOrderRepositoryMongo;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderRepositoryAdapter implements ServiceOrderRepositoryPort {
    private final ServiceOrderRepositoryMongo repositoryMongo;

    public ServiceOrderRepositoryAdapter(ServiceOrderRepositoryMongo repositoryMongo) {
        this.repositoryMongo = repositoryMongo;
    }

    @Override
    public ServiceOrder save(ServiceOrder serviceOrder) {
        return repositoryMongo.save(serviceOrder);
    }
}
