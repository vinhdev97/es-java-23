package com.vinhdev97.es.api.service.search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinhdev97.es.entity.Service;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceSearchResponse {
  private Long id;
  private String name;
  private OffsetDateTime createdAt;
  private String createdBy;
  private OffsetDateTime updatedAt;
  private String updatedBy;
  private OffsetDateTime deletedAt;

  private String deletedBy;

  public static ServiceSearchResponse of(Service service) {
    return ServiceSearchResponse.builder()
        .id(service.getId())
        .name(service.getName())
        .createdAt(service.getCreatedAt())
        .createdBy(service.getCreatedBy())
        .updatedAt(service.getUpdatedAt())
        .updatedBy(service.getUpdatedBy())
        .deletedAt(service.getDeletedAt())
        .deletedBy(service.getDeletedBy())
        .build();
  }
}
