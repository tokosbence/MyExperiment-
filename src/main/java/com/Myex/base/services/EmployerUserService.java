package com.Myex.base.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myex.base.models.EmployerUser;
import com.Myex.base.repositories.EmployerUserRepository;


@Service
public class EmployerUserService {
	@Autowired
	private EmployerUserRepository userRepository;
	
	public List<EmployerUser> getAllUser(){
		List<EmployerUser> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		
		return users;
	}
	
	public EmployerUser getUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void addUser(EmployerUser user) {
		userRepository.save(user);
	}
		
	public void deleteAllUser() {
		userRepository.deleteAll();
	}
}
