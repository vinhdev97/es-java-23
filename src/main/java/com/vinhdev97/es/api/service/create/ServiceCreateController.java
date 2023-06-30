package com.vinhdev97.es.api.service.create;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceCreateController {
  private final ServiceCreateService serviceCreateService;

  @PostMapping
  public ResponseEntity<ServiceCreateResponse> create(
      @RequestBody @Valid ServiceCreateRequest request, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input");
    }

    return ResponseEntity.ok(serviceCreateService.execute(request));
  }
}
