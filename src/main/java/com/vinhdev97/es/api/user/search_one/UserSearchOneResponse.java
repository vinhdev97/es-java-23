package com.vinhdev97.es.api.user.search_one;

import com.vinhdev97.es.entity.User;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchOneResponse {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;
  private OffsetDateTime createdAt;
  private String createdBy;
  private OffsetDateTime updatedAt;
  private String updatedBy;
  private OffsetDateTime deletedAt;
  private String deletedBy;

  public static UserSearchOneResponse of(User user) {
    return UserSearchOneResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .address(user.getAddress())
        .phoneNumber(user.getPhoneNumber())
        .email(user.getEmail())
        .createdAt(user.getCreatedAt())
        .createdBy(user.getCreatedBy())
        .updatedAt(user.getUpdatedAt())
        .updatedBy(user.getUpdatedBy())
        .deletedAt(user.getDeletedAt())
        .deletedBy(user.getDeletedBy())
        .build();
  }
}
