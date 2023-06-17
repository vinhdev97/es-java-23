package com.vinhdev97.es.api.service.delete;

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
public class ServiceDeleteResponse {
  private String message;

  public static ServiceDeleteResponse res(Long result) {
    return ServiceDeleteResponse.builder()
        .message(result > 0 ? "Delete success" : "Delete fail")
        .build();
  }
}
