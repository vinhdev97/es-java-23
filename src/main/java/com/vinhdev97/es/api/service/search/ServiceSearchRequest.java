package com.vinhdev97.es.api.service.search;

import com.vinhdev97.es.entity.Service;
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
public class ServiceSearchRequest {
  private Long id;
  private String name;
  private Long limit;
  private Long offset;
}
