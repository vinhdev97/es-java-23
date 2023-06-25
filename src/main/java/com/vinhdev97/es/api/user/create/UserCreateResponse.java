package com.vinhdev97.es.api.user.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.entity.User;
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
public class UserCreateResponse {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]X")
  private OffsetDateTime createdAt;
  private String createdBy;

  public static UserCreateResponse of(User user) {
    return UserCreateResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .email(user.getEmail())
        .phoneNumber(user.getPhoneNumber())
        .address(user.getAddress())
        .createdBy(user.getCreatedBy())
        .createdAt(user.getCreatedAt())
        .build();
  }
}
