package com.vinhdev97.es.api.user.update;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/** Service create controller. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/{userId}")
public class UserUpdateController {
  private final UserUpdateService userUpdateService;

  @PutMapping
  public ResponseEntity<UserUpdateResponse> update(
      @RequestBody @Valid UserUpdateRequest request, @PathVariable Long userId, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input");
    }

    return ResponseEntity.ok(userUpdateService.execute(request, userId));
  }
}
