package com.vinhdev97.es.api.user.search;

import com.vinhdev97.es.api.user.SearchUser;
import com.vinhdev97.es.entity.User;
import com.vinhdev97.es.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements SearchUser {

  private final UserRepository userRepository;

  @Override
  public UserPaginationSearchResponse execute(UserSearchRequest request, RowBounds rowBounds) {
    List<User> listUser = userRepository.search(request, rowBounds);
    List<UserSearchResponse> listUserRes = listUser.stream().map(UserSearchResponse::of).toList();
    long count = Math.toIntExact(userRepository.count(request));
    int totalPage = (int) Math.ceil((double) count / rowBounds.getLimit());

    return UserPaginationSearchResponse.of(
        listUserRes, rowBounds.getOffset() + 1, rowBounds.getLimit(), totalPage);
  }
}
