package com.vinhdev97.es.service.create;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceCreateController {
  private final ServiceCreateService serviceCreateService;

  @PostMapping
  public ResponseEntity create(
      @RequestBody @Valid ServiceCreateRequest request, BindingResult bindingResult) {
    try {
      if (bindingResult.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        bindingResult
            .getAllErrors()
            .forEach(
                (error) -> {
                  String fieldName = ((FieldError) error).getField();
                  String errorMessage = error.getDefaultMessage();
                  errors.put(fieldName, errorMessage);
                });

        return ResponseEntity.badRequest().body(errors);
      }

      return ResponseEntity.ok(serviceCreateService.execute(request));
    } catch (Exception ex) {
      Map<String, String> errors = new HashMap<>();
      errors.put("message", ex.getMessage());
      if(ex.getCause() != null && ex.getCause() instanceof SQLException) {
        errors.put("message", "SQL Exception");
      }

      return ResponseEntity.badRequest().body(errors);
    }
  }
}
