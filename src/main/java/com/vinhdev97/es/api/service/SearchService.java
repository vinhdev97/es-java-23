package com.vinhdev97.es.api.service;

import java.util.List;

public interface SearchService<T> {
  List<T> execute(Long id, String name, Long limit, Long offset);
}
