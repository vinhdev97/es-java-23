package com.vinhdev97.es.entity;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Service entity.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;

  /** <code>created_at</code>. */
  private String fullName;

  /** <code>email</code>. */
  private String email;

  /** <code>phone_number</code>. */
  private String phoneNumber;

  /** <code>address</code>. */
  private String address;

  /** <code>created_at</code>. */
  private OffsetDateTime createdAt;

  /** <code>created_by</code>. */
  private String createdBy;

  /** <code>updated_at</code>. */
  private OffsetDateTime updatedAt;

  /** <code>updated_by</code>. */
  private String updatedBy;

  /** <code>deleted_at</code>. */
  private OffsetDateTime deletedAt;

  /** <code>deleted_by</code>. */
  private String deletedBy;
}
