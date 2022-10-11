package com.in28minutes.restwebservices.restwebservices.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
  private static List<User> users = new ArrayList<>();

  static {
    users.add(new User(1, "Leonardo", LocalDate.now().minusYears(28)));
    users.add(new User(2, "Carlos", LocalDate.now().minusYears(28)));
    users.add(new User(3, "Gabriel", LocalDate.now().minusYears(28)));
    users.add(new User(4, "Brian", LocalDate.now().minusYears(24)));
    users.add(new User(5, "Gustavo", LocalDate.now().minusYears(25)));
  }

  public List<User> findAll() {
    return users;
  }

  public User findOne(int id) {
    return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public User addOne(User user) {
    User auxUser = new User(users.get(users.size() - 1).getId()+1, user.getName(), user.getBirthDate());
    users.add(auxUser);
    return auxUser;
  }

  public void deleteById(int id) {
    users.removeIf(user -> user.getId().equals(id));
  }
}
