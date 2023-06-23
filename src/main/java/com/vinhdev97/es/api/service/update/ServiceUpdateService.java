package com.vinhdev97.es.api.service.update;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.UpdateService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceUpdateService
    implements UpdateService<ServiceUpdateRequest, ServiceUpdateResponse> {
  private final ServiceRepository serviceRepository;

  public ServiceUpdateResponse execute(ServiceUpdateRequest request, Long serviceId) {
    Service serviceUpdate =
        request
            .toServiceBuilder()
            .updatedAt(OffsetDateTime.now())
            .updatedBy("vinhdev97_update")
            .build();

    serviceUpdate.setId(serviceId);
    serviceRepository.update(serviceUpdate, serviceId);

    return ServiceUpdateResponse.of(serviceUpdate);
  }
}
