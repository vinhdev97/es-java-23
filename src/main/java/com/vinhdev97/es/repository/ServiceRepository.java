package com.vinhdev97.es.repository;

import com.vinhdev97.es.entity.Service;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/** Service repository. */
@Mapper
public interface ServiceRepository {
  Long create(Service service);

  List<Service> findAll();
}
