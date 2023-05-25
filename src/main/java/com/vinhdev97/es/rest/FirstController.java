package com.vinhdev97.es.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** First Controller. */
@RestController
public class FirstController {

  @GetMapping("/")
  public String hello() {
    return "Hello ES class!";
  }
}
