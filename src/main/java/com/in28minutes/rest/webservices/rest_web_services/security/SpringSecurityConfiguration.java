package com.in28minutes.rest.webservices.rest_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfiguration {
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	// 1)All requests should be Authenticated
	http.authorizeHttpRequests(
			auth ->auth.anyRequest().authenticated()
			);
	// 2)If a request is not authenticated, a web page is shown
	http.httpBasic(withDefaults());
	//CSRF -> Post, Put
	http.csrf().disable();
	return http.build();
}
}
