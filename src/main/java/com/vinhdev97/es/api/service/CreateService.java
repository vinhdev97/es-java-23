package com.vinhdev97.es.api.service;

public interface CreateService<S, T> {
  T execute(S request);
}
