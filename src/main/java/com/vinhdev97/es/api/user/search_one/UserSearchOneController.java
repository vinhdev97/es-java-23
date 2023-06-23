package com.vinhdev97.es.api.user.search_one;

import jakarta.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/{userId}")
public class UserSearchOneController {

  String message = "message";
  private final UserSearchOneService userSearchOneService;

  @GetMapping
  public ResponseEntity search(@PathVariable @Valid Long userId) {
    UserSearchOneResponse serviceRes = userSearchOneService.execute(userId);
    if (serviceRes != null) {
      return ResponseEntity.ok(serviceRes);
    } else {
      Map<String, String> errors = new HashMap<>();
      errors.put(message, "User not exist");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleException(Exception ex) {
    Map<String, String> errors = new HashMap<>();
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
