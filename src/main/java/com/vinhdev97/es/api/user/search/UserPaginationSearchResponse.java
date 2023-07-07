package com.vinhdev97.es.api.user.search;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPaginationSearchResponse {
  private List<UserSearchResponse> items;
  private int pageSize;
  private int currentPage;
  private int totalPage;

  public static UserPaginationSearchResponse of(
      List<UserSearchResponse> items, int currentPage, int pageSize, int totalPage) {
    return UserPaginationSearchResponse.builder()
        .items(items)
        .currentPage(currentPage)
        .pageSize(pageSize)
        .totalPage(totalPage)
        .build();
  }
}
