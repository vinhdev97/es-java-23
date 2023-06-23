package com.vinhdev97.es.api.service.search;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.SearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceSearchService implements SearchService<ServiceSearchResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public List<ServiceSearchResponse> execute(Long id, String name, Long limit, Long offset) {
    List<Service> serviceList = serviceRepository.search(id, name, limit, offset);
    return serviceList.stream().map(ServiceSearchResponse::of).toList();
  }
}
