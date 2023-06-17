package com.vinhdev97.es.service.create;

import com.vinhdev97.es.entity.Service;
import java.time.OffsetDateTime;
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
public class ServiceCreateResponse {
  private Long id;
  private String name;
  private OffsetDateTime createdAt;
  private String createdBy;

  public static ServiceCreateResponse of(Service service) {
    return ServiceCreateResponse.builder()
        .id(service.getId())
        .name(service.getName())
        .createdBy(service.getCreatedBy())
        .createdAt(service.getCreatedAt())
        .build();
  }
}
