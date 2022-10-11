package com.in28minutes.restwebservices.restwebservices.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {
  
  private PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> getAllPosts() {
    return repository.findAll();
  } 

  public void createPost(Post post) {
    repository.save(post);
  }

  public List<Post> getAllUserPosts(int id) {
    return repository.findByUserId(id);
  }

}
