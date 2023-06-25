package com.vinhdev97.es.api.user.search;

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
public class UserSearchRequest {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;
  private Long limit;
  private Long offset;
}
