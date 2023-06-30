package com.vinhdev97.es.api.user.update;

import com.vinhdev97.es.api.user.UpdateUser;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserUpdateService
    implements UpdateUser<UserUpdateRequest, UserUpdateResponse> {
  private final UserRepository UserRepository;

  public UserUpdateResponse execute(UserUpdateRequest request, Long serviceId) {
    User userUpdate =
        request
            .toServiceBuilder()
            .updatedAt(OffsetDateTime.now())
            .updatedBy("vinhdev97_update")
            .build();

    userUpdate.setId(serviceId);
    UserRepository.update(userUpdate, serviceId);

    return UserUpdateResponse.of(userUpdate);
  }
}
