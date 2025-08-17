package com.mecanica.feicina.api.mapper;

import com.mecanica.feicina.api.dto.ServiceOrderRequestDTO;
import com.mecanica.feicina.api.dto.ServiceOrderResponseDTO;
import com.mecanica.feicina.domain.model.ServiceOrder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ServiceOrderMapper {

    public ServiceOrder toDomain(ServiceOrderRequestDTO dto) {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setCustomerId(dto.customerId());
        serviceOrder.setStatus(dto.status());

        if (dto.services() != null) {
            serviceOrder.setServices(dto.services().stream().map(s -> {
                ServiceOrder.Service service = new ServiceOrder.Service();
                service.setDescription(s.description());
                service.setPrice(s.price());
                return service;
            }).collect(Collectors.toList()));
        }

        if (dto.parts() != null) {
            serviceOrder.setParts(dto.parts().stream().map(p -> {
                ServiceOrder.Part part = new ServiceOrder.Part();
                part.setName(p.name());
                part.setQuantity(p.quantity());
                part.setUnitPrice(p.unitPrice());
                return part;
            }).collect(Collectors.toList()));
        }

        return serviceOrder;
    }

    public ServiceOrderResponseDTO toResponseDTO(ServiceOrder serviceOrder) {
        return new ServiceOrderResponseDTO(
                serviceOrder.getId(),
                serviceOrder.getCustomerId(),
                serviceOrder.getStatus(),
                serviceOrder.getServices().stream().map(s -> new ServiceOrderResponseDTO.ServiceDTO(
                        s.getDescription(),
                        s.getPrice()
                )).collect(Collectors.toList()),
                serviceOrder.getParts().stream().map(p -> new ServiceOrderResponseDTO.PartDTO(
                        p.getName(),
                        p.getQuantity(),
                        p.getUnitPrice()
                )).collect(Collectors.toList()),
                serviceOrder.getTotalPrice()
        );
    }
}