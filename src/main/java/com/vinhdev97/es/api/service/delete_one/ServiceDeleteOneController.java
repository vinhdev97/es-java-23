package com.vinhdev97.es.api.service.delete_one;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services/{id}")
public class ServiceDeleteOneController {
  private final ServiceDeleteOneService serviceDeleteService;

  @DeleteMapping
  public ResponseEntity<ServiceDeleteOneResponse> delete(
      @PathVariable Long id) {
    return ResponseEntity.ok(serviceDeleteService.execute(id));
  }
}
