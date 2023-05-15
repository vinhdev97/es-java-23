package vinhdev97.ES_Java.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    public String hello() {
        return "Hello ES class!";
    }
}
