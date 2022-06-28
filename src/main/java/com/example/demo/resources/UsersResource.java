package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;

@RestController
@RequestMapping(value="/users")
public class UsersResource {
	
	@GetMapping
	public ResponseEntity<Users> findAll(){
		Users u = new Users(1L, "jonathan", "jonathan@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
