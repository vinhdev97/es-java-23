package com.vinhdev97.es.api.user.delete;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserDeleteController {
  private final UserDeleteService userDeleteService;

  @DeleteMapping
  public ResponseEntity<UserDeleteResponse> delete(
      @RequestBody @Valid UserDeleteRequest request) {
    return ResponseEntity.ok(userDeleteService.execute(request));
  }
}
