package com.vinhdev97.es.api.service.delete;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceDeleteController {
  private final ServiceDeleteService serviceDeleteService;

  @DeleteMapping
  public ResponseEntity<ServiceDeleteResponse> delete(
      @RequestBody @Valid ServiceDeleteRequest request) {
    return ResponseEntity.ok(serviceDeleteService.execute(request));
  }
}
