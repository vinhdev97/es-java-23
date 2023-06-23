package com.vinhdev97.es.repository;

import com.vinhdev97.es.entity.Service;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/** Service repository. */
@Mapper
public interface ServiceRepository {
  Long create(Service service);

  Long update(Service service, Long id);

  Long softDelete(Service service, List<Long> serviceIds);

  Long delete(Service service, Long id);

  Service findById(Long id);

  List<Service> search(Long id, String name, Long limit, Long offset);
}
