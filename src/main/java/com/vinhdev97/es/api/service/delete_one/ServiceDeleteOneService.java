package com.vinhdev97.es.api.service.delete_one;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.DeleteOneService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceDeleteOneService implements DeleteOneService<ServiceDeleteOneResponse> {
  private final ServiceRepository serviceRepository;

  public ServiceDeleteOneResponse execute(Long id) {
    Service service = Service.builder()
            .deletedBy("vinhdev97_delete")
            .deletedAt(OffsetDateTime.now())
            .build();

    Long deleted = serviceRepository.delete(service, id);
    return ServiceDeleteOneResponse.res(deleted);
  }
}
