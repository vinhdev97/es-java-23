package com.vinhdev97.es.api.user.delete;

import com.vinhdev97.es.entity.User;
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
public class UserDeleteRequest {
  @NotNull
  private List<Long> userIds;

  public User.UserBuilder toUserBuilder() {
    return User.builder();
  }
}
