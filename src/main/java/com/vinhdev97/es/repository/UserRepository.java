package com.vinhdev97.es.repository;

import com.vinhdev97.es.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/** Service repository. */
@Mapper
public interface UserRepository {

  User findById(Long id);

  List<User> search(
      Long id,
      String fullName,
      String phoneNumber,
      String email,
      String address,
      Long limit,
      Long offset);

  Long count(
      Long id,
      String fullName,
      String phoneNumber,
      String email,
      String address);
}
