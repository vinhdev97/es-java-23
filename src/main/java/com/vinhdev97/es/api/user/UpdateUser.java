package com.vinhdev97.es.api.user;

public interface UpdateUser<S, T> {
  T execute(S request, Long id);
}
