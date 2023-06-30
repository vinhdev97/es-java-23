package com.vinhdev97.es.api.user.create;

import com.vinhdev97.es.api.service.CreateService;
import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.ServiceRepository;
import com.vinhdev97.es.repository.UserRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService
    implements CreateService<UserCreateRequest, UserCreateResponse> {

  private final UserRepository userRepository;

  public UserCreateResponse execute(
      UserCreateRequest request) {
    User user =
        request.toServiceBuilder().createdAt(OffsetDateTime.now()).createdBy("vinhdev97").build();
    userRepository.create(user);
    return UserCreateResponse.of(user);
  }
}
