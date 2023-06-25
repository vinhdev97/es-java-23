package com.vinhdev97.es.api.service.service_one;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services/{serviceId}")
public class ServiceSearchOneController {

  String message = "message";
  private final ServiceSearchOneService serviceSearchOneService;

  @GetMapping
  public ResponseEntity<ServiceSearchOneResponse> search(@PathVariable @Valid Long serviceId) {
    ServiceSearchOneResponse serviceRes = serviceSearchOneService.execute(serviceId);
    if (serviceRes != null) {
      return ResponseEntity.ok(serviceRes);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}
