package com.vinhdev97.es.api.user.delete_one;

import com.vinhdev97.es.api.service.DeleteOneService;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteOneService implements DeleteOneService<UserDeleteOneResponse> {
  private final UserRepository userRepository;

  public UserDeleteOneResponse execute(Long id) {
    User user = User.builder()
            .deletedBy("vinhdev97_delete")
            .deletedAt(OffsetDateTime.now())
            .build();

    Long deleted = userRepository.delete(user, id);
    return UserDeleteOneResponse.res(deleted);
  }
}
