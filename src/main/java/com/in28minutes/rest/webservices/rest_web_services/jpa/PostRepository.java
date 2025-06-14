package com.in28minutes.rest.webservices.rest_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.rest_web_services.user.Post;
import com.in28minutes.rest.webservices.rest_web_services.user.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
