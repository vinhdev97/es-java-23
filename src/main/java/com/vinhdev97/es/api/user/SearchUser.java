package com.vinhdev97.es.api.user;

import com.vinhdev97.es.api.user.search.UserPaginationSearchResponse;
import com.vinhdev97.es.api.user.search.UserSearchRequest;
import org.apache.ibatis.session.RowBounds;

public interface SearchUser {
  UserPaginationSearchResponse execute(
      UserSearchRequest request,
      RowBounds rowBounds);
}
