package com.vinhdev97.es.api.user.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinhdev97.es.api.user.create.UserCreateResponse;
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
public class UserUpdateResponse {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]X")
  private OffsetDateTime updatedAt;
  private String updatedBy;

  public static UserUpdateResponse of(User user) {
    return UserUpdateResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .email(user.getEmail())
        .phoneNumber(user.getPhoneNumber())
        .address(user.getAddress())
        .updatedBy(user.getUpdatedBy())
        .updatedAt(user.getUpdatedAt())
        .build();
  }
}
