package com.vinhdev97.es.api.user.search;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.http.ResponseEntity;
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
      @RequestParam(defaultValue = "20") @Nullable int size,
      @RequestParam(defaultValue = "1") @Nullable int page) {
    UserSearchRequest request = new UserSearchRequest(id, fullName, email, phoneNumber, address, size, page);
    RowBounds rowBounds = new RowBounds((page < 1 ? 1 : page - 1) * size, size);

    return ResponseEntity.ok(
        userSearchService.execute(request, rowBounds));
  }
}
