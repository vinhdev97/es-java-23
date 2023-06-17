package com.vinhdev97.es.api.service.service_one;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.SearchOneService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceSearchOneService implements SearchOneService<ServiceSearchOneResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceSearchOneResponse execute(Long id) {
    Service service = serviceRepository.findById(id);

    if (service != null) {
      return ServiceSearchOneResponse.of(service);
    } else {
      return null;
    }
  }
}
