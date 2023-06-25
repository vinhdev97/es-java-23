package com.vinhdev97.es.api.user.search_one;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/{userId}")
public class UserSearchOneController {

  String message = "message";
  private final UserSearchOneService userSearchOneService;

  @GetMapping
  public ResponseEntity<UserSearchOneResponse> search(@PathVariable @Valid Long userId) {
    UserSearchOneResponse serviceRes = userSearchOneService.execute(userId);
    if (serviceRes != null) {
      return ResponseEntity.ok(serviceRes);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
}
