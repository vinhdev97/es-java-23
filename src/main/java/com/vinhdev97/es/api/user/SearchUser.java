package com.vinhdev97.es.api.user;

import com.vinhdev97.es.api.user.search.UserPaginationSearchResponse;

public interface SearchUser {
  UserPaginationSearchResponse execute(
      Long id,
      String fullName,
      String phoneNumber,
      String email,
      String address,
      Long limit,
      Long offset);
}
