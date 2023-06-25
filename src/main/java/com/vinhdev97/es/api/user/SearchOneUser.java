package com.vinhdev97.es.api.user;

public interface SearchOneUser<T> {
  T execute(Long id);
}
