package com.in28minutes.restwebservices.restwebservices.helloworld;

public class HelloWorld {
  private String greeting;

  public HelloWorld(String message) {
    this.greeting = message;
  }

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

}
