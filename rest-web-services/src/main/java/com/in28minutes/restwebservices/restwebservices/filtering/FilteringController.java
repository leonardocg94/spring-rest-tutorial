package com.in28minutes.restwebservices.restwebservices.filtering;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public List<SomeBean> filtering() {

    return List.of(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
  }

}
