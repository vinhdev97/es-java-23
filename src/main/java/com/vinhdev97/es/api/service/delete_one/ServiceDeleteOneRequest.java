package com.vinhdev97.es.api.service.delete_one;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDeleteOneRequest {
  @NotNull(message = "serviceIds là trường bắt buộc.")
  private List<Long> serviceIds;
}
