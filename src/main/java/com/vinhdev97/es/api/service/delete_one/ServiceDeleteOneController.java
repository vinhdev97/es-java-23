package com.vinhdev97.es.api.service.delete_one;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleException(Exception ex) {
    Map<String, String> errors = new HashMap<>();
    String message = "message";
    errors.put(message, ex.getMessage());
    if (ex.getCause() != null) {
      errors.put(message, ex.getCause().getMessage());
      if (ex.getCause() instanceof SQLException) {
        errors.put(message, "SQL Exception");
      }
    }

    return ResponseEntity.badRequest().body(errors);
  }
}
