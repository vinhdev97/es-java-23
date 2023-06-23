package com.vinhdev97.es.api.service;

public interface UpdateService<S, T> {
  T execute(S request, Long id);
}
