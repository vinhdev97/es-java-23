package com.vinhdev97.es.api.service.delete_one;

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
public class ServiceDeleteOneResponse {
  private String message;

  public static ServiceDeleteOneResponse res(Long result) {
    return ServiceDeleteOneResponse.builder()
        .message(result > 0 ? "Delete success" : "Delete fail")
        .build();
  }
}
