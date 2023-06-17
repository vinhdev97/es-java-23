package com.vinhdev97.es.api.service.update;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ServiceUpdateResponse {
  private Long id;
  private String name;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]X")
  private OffsetDateTime updatedAt;
  private String updatedBy;

  public static ServiceUpdateResponse of(Service service) {
    return ServiceUpdateResponse.builder()
        .id(service.getId())
        .name(service.getName())
        .updatedBy(service.getUpdatedBy())
        .updatedAt(service.getUpdatedAt())
        .build();
  }
}
