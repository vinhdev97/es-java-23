package com.vinhdev97.es.api.user.search;

import com.vinhdev97.es.entity.User;
import java.time.OffsetDateTime;
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
  private Long pageSize;
  private Long currentPage;
  private Long totalPage;

  public static UserPaginationSearchResponse of(
      List<UserSearchResponse> items, Long currentPage, Long pageSize, Long totalPage) {
    return UserPaginationSearchResponse.builder()
        .items(items)
        .currentPage(currentPage)
        .pageSize(pageSize)
        .totalPage(totalPage)
        .build();
  }
}
