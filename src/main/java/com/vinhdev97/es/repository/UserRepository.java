package com.vinhdev97.es.repository;

import com.vinhdev97.es.api.user.search.UserSearchRequest;
import com.vinhdev97.es.entity.Service;
import com.vinhdev97.es.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

/** Service repository. */
@Mapper
public interface UserRepository {

  Long create(User user);

  Long update(User user, Long id);

  Long softDelete(User user, List<Long> userIds);

  Long delete(User user, Long id);
  User findById(Long id);

  List<User> search(UserSearchRequest request, RowBounds rowBounds);

  Long count(UserSearchRequest request);
}
