package com.vinhdev97.es.api.user.search;

import com.vinhdev97.es.api.user.SearchUser;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements SearchUser {

  private final UserRepository userRepository;

  @Override
  public UserPaginationSearchResponse execute(
      Long id,
      String fullName,
      String phoneNumber,
      String email,
      String address,
      Long limit,
      Long offset) {
    List<User> listUser =
        userRepository.search(id, fullName, phoneNumber, email, address, limit, offset);
    List<UserSearchResponse> listUserRes = listUser.stream().map(UserSearchResponse::of).toList();
    long count =
        Math.toIntExact(
            userRepository.count(id, fullName, phoneNumber, email, address));
    Long totalPage = (long) Math.ceil((double)count / limit);

    return UserPaginationSearchResponse.of(listUserRes, offset + 1, limit, totalPage);
  }
}
