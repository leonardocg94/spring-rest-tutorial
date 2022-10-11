package com.in28minutes.restwebservices.restwebservices.posts;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restwebservices.restwebservices.Users.User;
import com.in28minutes.restwebservices.restwebservices.Users.UserNotFoundException;
import com.in28minutes.restwebservices.restwebservices.Users.UserService;


@RestController
public class PostController {

  private PostService service;
  private UserService userService;

  public PostController(PostService service, UserService userService) {
    this.service = service;
    this.userService = userService;
  }
  
  @GetMapping("/posts")
  public List<Post> retrieveAllPosts() {
    return service.getAllPosts();
  }

  @GetMapping("/users/{id}/posts")
  public List<Post> retrieveUserPosts(@PathVariable int id) {
    List<Post> posts = service.getAllUserPosts(id);
    
    if(posts.isEmpty())
      throw new UserNotFoundException("Este usuario no existe");
    
    return posts;
  }

  @PostMapping("/users/{id}/posts")
  public ResponseEntity<Post> createPostForUser(@PathVariable int id, @RequestBody Post post) {
    System.out.println(post.toString());

    Optional<User> opUser = userService.getUserById(id);
    if(opUser.isEmpty())
      throw new UserNotFoundException("Usuario no valido para guardar el post");
    
    post.setUser(opUser.get());
    service.createPost(post);

    return ResponseEntity.created(null).build();
  }
}
