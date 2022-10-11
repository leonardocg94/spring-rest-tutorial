package com.in28minutes.restwebservices.restwebservices.Users;

import java.time.LocalDate;
import java.util.List;

import com.in28minutes.restwebservices.restwebservices.posts.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 2, message = "Name should have at least 2 characters")
  // @JsonProperty("user_name")
  private String name;
  @Past(message = "Birthdate should be in the past")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;

  public User() {}

  public User(Integer id, String name, LocalDate birthDate) {
    super();
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

}
