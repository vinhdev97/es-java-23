package com.vinhdev97.es.api.service.update;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services/{serviceId}")
public class ServiceUpdateController {
  private final ServiceUpdateService serviceUpdateService;

  @PutMapping
  public ResponseEntity<ServiceUpdateResponse> update(
      @RequestBody @Valid ServiceUpdateRequest request, @PathVariable Long serviceId, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input");
    }

    return ResponseEntity.ok(serviceUpdateService.execute(request, serviceId));
  }
}
