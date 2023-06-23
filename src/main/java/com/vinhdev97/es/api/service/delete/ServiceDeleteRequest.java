package com.vinhdev97.es.api.service.delete;

import com.vinhdev97.es.entity.Service;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDeleteRequest {
  @NotNull(message = "serviceIds là trường bắt buộc.")
  private List<Long> serviceIds;

  public Service.ServiceBuilder toServiceBuilder() {
    return Service.builder();
  }
}
