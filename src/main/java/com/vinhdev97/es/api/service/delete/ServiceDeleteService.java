package com.vinhdev97.es.api.service.delete;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.DeleteService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceDeleteService
    implements DeleteService<ServiceDeleteRequest, ServiceDeleteResponse> {
  private final ServiceRepository serviceRepository;

  public ServiceDeleteResponse execute(ServiceDeleteRequest request) {
    Service service =
        request
            .toServiceBuilder()
            .deletedBy("vinhdev97_delete")
            .deletedAt(OffsetDateTime.now())
            .build();
    Long deleted = serviceRepository.softDelete(service, request.getServiceIds());
    return ServiceDeleteResponse.res(deleted);
  }
}
