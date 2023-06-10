package com.vinhdev97.es.service.search;

import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.repository.ServiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service search controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceRepository serviceRepository;

  @GetMapping
  public List<Service> search() {
    return serviceRepository.findAll();
  }
}
