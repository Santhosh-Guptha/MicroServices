package com.RestTemplate.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.RestTemplate.UserService.entities.User;
import com.RestTemplate.UserService.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User body){
		return new ResponseEntity<User>(service.save(body),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		return new ResponseEntity<User>(service.getById(id),HttpStatus.OK);
	}
	
	@PutExchange("/update/{id}")
	public User updateUser(@RequestBody User body,@PathVariable("id") int id){
		return service.updateUser(body, id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public User deleteById(@PathVariable("id") int id) {
		return service.deleteUserById(id);
	}
}
