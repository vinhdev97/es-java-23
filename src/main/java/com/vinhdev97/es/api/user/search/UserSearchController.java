package com.vinhdev97.es.api.user.search;

import jakarta.annotation.Nullable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserSearchController {

  private final UserSearchService userSearchService;

  @GetMapping
  public ResponseEntity<UserPaginationSearchResponse> search(
      @RequestParam @Nullable Long id,
      @RequestParam @Nullable String fullName,
      @RequestParam @Nullable String phoneNumber,
      @RequestParam @Nullable String email,
      @RequestParam @Nullable String address,
      @RequestParam(defaultValue = "3") @Nullable Long size,
      @RequestParam(defaultValue = "1") @Nullable Long page) {

    return ResponseEntity.ok(
        userSearchService.execute(
            id, fullName, phoneNumber, email, address, size, (page < 1 ? 1 : page - 1)));
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
