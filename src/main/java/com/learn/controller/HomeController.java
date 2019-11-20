package com.learn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.model.User;
import com.learn.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService service;
	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_WELCOME");
		return "welcome";
	}
	@RequestMapping("/register")
	public String registeration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcome";
	}
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute User user,BindingResult br,HttpServletRequest request) {
		service.saveUser(user);
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcome";
	}
	@GetMapping("/show-users")
	public String allUser(HttpServletRequest request) {
		request.setAttribute("users", service.getAllUser());
		request.setAttribute("mode","ALL_USERS");
		return "welcome";
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		service.deleteMyUser(id);
		request.setAttribute("users", service.getAllUser());
		request.setAttribute("mode","ALL_USERS");
		return "welcome";
	}
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", service.editUser(id).get());
		request.setAttribute("mode", "UPDATE_USER");
		return "welcome"; 
	}
}
