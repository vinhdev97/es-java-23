package com.vinhdev97.es.api.user.create;

import com.vinhdev97.es.entity.User;
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
public class UserCreateRequest {

  @NotNull
  @Size(max = 256)
  private String fullName;

  @NotNull
  @Size(max = 256)
  private String email;

  @NotNull
  @Size(max = 256)
  private String phoneNumber;

  @NotNull
  @Size(max = 256)
  private String address;

  public User.UserBuilder toServiceBuilder() {
    return User.builder()
        .fullName(this.fullName)
        .phoneNumber(this.phoneNumber)
        .address(this.address)
        .email(this.email);
  }
}
