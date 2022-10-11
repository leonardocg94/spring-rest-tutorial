package com.in28minutes.restwebservices.restwebservices.Users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserDaoService service;
  private UserService h2Service;

  public UserController(UserDaoService service, UserService h2Service) {
    this.service = service;
    this.h2Service = h2Service;
  }

  @GetMapping("")
  public List<User> retrieveAllUsers() {
    return service.findAll();
  }

  @GetMapping("/h2")
  public List<User> retrieveAllH2Users() {
    return h2Service.retrieveAllH2Users();
  }

  @GetMapping("/{id}")
  public User retrieveOneUser(@PathVariable int id) {
    User user = service.findOne(id);
    if (user == null)
      throw new UserNotFoundException("Usuario no encontrado");
    return user;
  }

  @GetMapping("/h2/{id}")
  public User retrieveOneH2User(@PathVariable int id) {
    Optional<User> opUser = h2Service.getUserById(id);
    if (opUser.isEmpty())
      throw new UserNotFoundException("Usuario no encontrado");

    return opUser.get();
  }

  @PostMapping("")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User createdUser = service.addOne(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @PostMapping("/h2")
  public ResponseEntity<User> createH2User(@Valid @RequestBody User user) {
    User createdUser = h2Service.creteOne(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable int id) {
    service.deleteById(id);
  }

  @DeleteMapping("/h2/{id}")
  public void deleteH2User(@PathVariable int id) {
    h2Service.deleteUserById(id);
  }
}
