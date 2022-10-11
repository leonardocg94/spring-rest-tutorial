package com.in28minutes.restwebservices.restwebservices.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> retrieveAllH2Users() {
    return repository.findAll();
  }

  public Optional<User> getUserById(int id) {
    return repository.findById(id);
  }

  public void deleteUserById(int id) {
    repository.deleteById(id);
  }

  public User creteOne(User user) {
    return repository.save(user);
  }

}
