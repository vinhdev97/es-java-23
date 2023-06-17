package com.vinhdev97.es.api.service.delete;

import jakarta.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleException(Exception ex) {
    Map<String, String> errors = new HashMap<>();
    errors.put("message", ex.getMessage());
    if (ex.getCause() != null) {
      errors.put("message", ex.getCause().getMessage());
      if (ex.getCause() instanceof SQLException) {
        errors.put("message", "SQL Exception");
      }
    }

    return ResponseEntity.badRequest().body(errors);
  }
}
