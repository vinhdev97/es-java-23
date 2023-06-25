package com.vinhdev97.es.api.service.update;

import jakarta.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services/{serviceId}")
public class ServiceUpdateController {
  private final ServiceUpdateService serviceUpdateService;

  @PutMapping
  public ResponseEntity update(
      @RequestBody @Valid ServiceUpdateRequest request, @PathVariable Long serviceId, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errors = new HashMap<>();
      bindingResult
          .getAllErrors()
          .forEach(
              error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
              });

      return ResponseEntity.badRequest().body(errors);
    }

    return ResponseEntity.ok(serviceUpdateService.execute(request, serviceId));
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
