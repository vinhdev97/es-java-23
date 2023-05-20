package vinhdev97.es_java.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

  @GetMapping("/")
  public String hello() {
    return "Hello ES class!";
  }
}
