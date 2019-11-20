package com.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.model.User;
import com.learn.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	public void saveUser(User user) {
		repo.save(user);
	}
	public List<User> getAllUser(){
		List<User> users = new ArrayList<>();
		for(User user : repo.findAll()) {
			users.add(user);
		}
		return users;
	}
	public void deleteMyUser(int id) {
		repo.deleteById(id);
	}
	public Optional<User> editUser(int id){
		return repo.findById(id);
	}
}
