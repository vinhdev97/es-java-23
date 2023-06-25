package com.vinhdev97.es.api.user.delete_one;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteOneResponse {
  private String message;

  public static UserDeleteOneResponse res(Long result) {
    return UserDeleteOneResponse.builder()
        .message(result > 0 ? "Delete success" : "Delete fail")
        .build();
  }
}
