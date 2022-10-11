package com.in28minutes.restwebservices.restwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  
  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello world"; 
  }

  @GetMapping("/hello-bean")
  public HelloWorld helloWorldBean() {
    return new HelloWorld("Hola Papu");
  }

  @GetMapping("/hello/path-variable/{name}")
  public HelloWorld helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorld(String.format("Hola %s", name));
  }

  @GetMapping("/hello/parameter")
  public HelloWorld helloWorldParameter(@RequestParam(defaultValue = "no name") String name){
    return new HelloWorld(String.format("Hola %s", name));
  }
}
