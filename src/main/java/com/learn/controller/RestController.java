//package com.learn.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.learn.model.User;
//import com.learn.service.UserService;
//
//@org.springframework.web.bind.annotation.RestController
//public class RestController {
//
//	@Autowired
//	private  UserService service;
//	@GetMapping("")
//	public String hello() {
//		return "hello springboot";
//	}
//	@GetMapping("/saveuser")
//	public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password ) {
//		User user = new User(username, firstname, lastname, age, password);
//		service.saveUser(user);
//		return "user saved";
//	}
//	
//}
