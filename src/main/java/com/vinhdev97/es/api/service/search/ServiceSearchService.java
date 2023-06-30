package com.vinhdev97.es.api.service.search;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.api.service.SearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceSearchService implements SearchService<ServiceSearchResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public List<ServiceSearchResponse> execute(ServiceSearchRequest request, RowBounds rowBounds) {
    List<Service> serviceList = serviceRepository.search(request, rowBounds);
    return serviceList.stream().map(ServiceSearchResponse::of).toList();
  }
}
