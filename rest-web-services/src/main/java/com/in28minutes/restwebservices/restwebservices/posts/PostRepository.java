package com.in28minutes.restwebservices.restwebservices.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
  public List<Post> findByUserId(int id);
}
