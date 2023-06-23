package com.vinhdev97.es.api.service.search;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceSearchService serviceSearchService;

  @GetMapping
  public ResponseEntity<List<ServiceSearchResponse>> search(
      @RequestParam @Nullable Long id,
      @RequestParam @Nullable String name,
      @RequestParam @Nullable Long limit,
      @RequestParam @Nullable Long offset) {
    return ResponseEntity.ok(
        serviceSearchService.execute(id, name, limit, offset));
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
