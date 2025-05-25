package com.in28minutes.rest.webservices.rest_web_services.jpa;

import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.rest_web_services.user.Post;
import com.in28minutes.rest.webservices.rest_web_services.user.User;
import com.in28minutes.rest.webservices.rest_web_services.user.UserDaoService;
import com.in28minutes.rest.webservices.rest_web_services.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserjpaResource {
	//private UserDaoService service;
	private UserRepository repository;
	private PostRepository postrepository;

	public UserjpaResource(UserRepository repository, PostRepository postrepository) {
		super();
//		this.service = service;
		this.repository=repository;
		this.postrepository=postrepository;
	}
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	 @GetMapping("/jpa/user/{id}")
	 public EntityModel<User> retrieveUser(@PathVariable int id) {
		 Optional<User> user = repository.findById(id);
		 
		 if(user.isEmpty()) {
			 throw new UserNotFoundException("id:"+id);
		 }
		 EntityModel<User> entityModel=EntityModel.of(user.get());
		 WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 entityModel.add(link.withRel("all-users"));
		return entityModel;
	 }
	 @DeleteMapping("/jpa/users/{id}")
	 public void deleteUser(@PathVariable int id) {
		 repository.deleteById(id);
	 }
	 @GetMapping("/jpa/users/{id}/posts")
	 public List<Post> retrivePostsForUser(@PathVariable int id) {
      Optional<User> user = repository.findById(id);
		 if(user.isEmpty()) {
			 throw new UserNotFoundException("id:"+id);
		 }
		return user.get().getPosts();
	 }
@PostMapping("/jpa/users")
public ResponseEntity<User>createUser (@Valid @RequestBody User user) {
	User savedUser=repository.save(user);
	 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
}
@PostMapping("/jpa/users/{id}/posts")
public ResponseEntity<Object> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post) {
 Optional<User> user = repository.findById(id);
	 if(user.isEmpty()) {
		 throw new UserNotFoundException("id:"+id);
	 }
	post.setUser(user.get());
	Post savedPost=postrepository.save(post);
	 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
}

}
