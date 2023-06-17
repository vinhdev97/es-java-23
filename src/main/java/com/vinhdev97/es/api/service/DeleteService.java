package com.vinhdev97.es.api.service;

import java.lang.reflect.Array;

public interface DeleteService<S, T> {
  T execute(S request);
}
