package com.vinhdev97.es.api.service;

import com.vinhdev97.es.api.service.search.ServiceSearchRequest;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface SearchService<T> {
  List<T> execute(ServiceSearchRequest request, RowBounds rowBounds);
}
