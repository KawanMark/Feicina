package com.mecanica.feicina.infrastructure.persistence.mongodb.repository;

import com.mecanica.feicina.domain.model.ServiceOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceOrderRepositoryMongo extends MongoRepository<ServiceOrder, String>{
    // This interface extends MongoRepository to provide CRUD operations for ServiceOrder entities.
    // Additional custom query methods can be defined here if needed.
}
