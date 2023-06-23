package com.vinhdev97.es.api.user.search_one;

import com.vinhdev97.es.api.user.SearchOneUser;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchOneService implements SearchOneUser<UserSearchOneResponse> {

  private final UserRepository userRepository;

  @Override
  public UserSearchOneResponse execute(Long id) {
    User user = userRepository.findById(id);

    if (user != null) {
      return UserSearchOneResponse.of(user);
    } else {
      return null;
    }
  }
}
