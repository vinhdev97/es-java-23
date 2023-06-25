package com.vinhdev97.es.api.user.delete_one;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/{id}")
public class UserDeleteOneController {
  private final UserDeleteOneService userDeleteService;

  @DeleteMapping
  public ResponseEntity<UserDeleteOneResponse> delete(
      @PathVariable Long id) {
    return ResponseEntity.ok(userDeleteService.execute(id));
  }
}
