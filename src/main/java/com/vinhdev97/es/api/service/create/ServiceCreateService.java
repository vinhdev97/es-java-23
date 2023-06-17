package com.vinhdev97.es.api.service.create;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.CreateService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceCreateService
    implements CreateService<ServiceCreateRequest, ServiceCreateResponse> {
  private final ServiceRepository serviceRepository;

  public ServiceCreateResponse execute(ServiceCreateRequest request) {
    Service service =
        request.toServiceBuilder().createdAt(OffsetDateTime.now()).createdBy("vinhdev97").build();
    serviceRepository.create(service);
    return ServiceCreateResponse.of(service);
  }
}
