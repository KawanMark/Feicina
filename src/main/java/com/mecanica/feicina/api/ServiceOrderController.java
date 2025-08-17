package com.mecanica.feicina.api;

import com.mecanica.feicina.api.dto.ServiceOrderRequestDTO;
import com.mecanica.feicina.api.dto.ServiceOrderResponseDTO;
import com.mecanica.feicina.api.mapper.ServiceOrderMapper;
import com.mecanica.feicina.domain.model.ServiceOrder;
import com.mecanica.feicina.domain.ports.in.CreateServiceOrderUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderController {

    private final CreateServiceOrderUseCase useCase;
    private final ServiceOrderMapper mapper;

    public ServiceOrderController(CreateServiceOrderUseCase useCase, ServiceOrderMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ServiceOrderResponseDTO create(@RequestBody ServiceOrderRequestDTO requestDTO) {
        ServiceOrder domainObj = mapper.toDomain(requestDTO);
        ServiceOrder savedDomainObj = useCase.create(domainObj);
        return mapper.toResponseDTO(savedDomainObj);
    }
}