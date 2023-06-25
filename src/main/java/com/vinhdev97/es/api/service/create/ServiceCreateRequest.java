package com.vinhdev97.es.api.service.create;

import com.vinhdev97.es.entity.Service;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ServiceCreateRequest {

  @NotNull(message = "Tên là trường bắt buộc.")
  @Size(max = 256, message = "Tên tối đa 256 ký tự.")
  private String name;

  public Service.ServiceBuilder toServiceBuilder() {
    return Service.builder().name(this.name);
  }
}
