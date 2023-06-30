package com.vinhdev97.es.api.user.delete;

import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteService {
  private final UserRepository userRepository;

  public UserDeleteResponse execute(
      UserDeleteRequest request) {
    User user =
        request
            .toUserBuilder()
            .deletedBy("vinhdev97_delete")
            .deletedAt(OffsetDateTime.now())
            .build();
    Long deleted = userRepository.softDelete(user, request.getUserIds());
    return UserDeleteResponse.res(deleted);
  }
}
